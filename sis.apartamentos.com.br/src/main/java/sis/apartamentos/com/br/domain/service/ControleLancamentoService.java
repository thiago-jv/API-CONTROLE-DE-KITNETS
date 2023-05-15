package sis.apartamentos.com.br.domain.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.api.v1.mapper.ApartamentoMapper;
import sis.apartamentos.com.br.api.v1.mapper.ControleLancamentoMapper;
import sis.apartamentos.com.br.api.v1.mapper.ControleLancamentoReportMapper;
import sis.apartamentos.com.br.domain.model.Inquilino;
import sis.apartamentos.com.br.domain.model.Predio;
import sis.apartamentos.com.br.domain.repository.ControleLancamentorReportRepository;
import sis.apartamentos.com.br.infra.dto.LancamentoApartamentoDTO;
import sis.apartamentos.com.br.infra.exception.ControleLancamentoNaoEncontadoException;
import sis.apartamentos.com.br.infra.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.infra.exception.PredioNaoEncontadoException;
import sis.apartamentos.com.br.infra.exception.ReportException;
import sis.apartamentos.com.br.domain.model.Apartamento;
import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.domain.model.controle.lancamento.CalculaDias;
import sis.apartamentos.com.br.domain.model.controle.lancamento.CalculaValorDiaria;
import sis.apartamentos.com.br.domain.model.controle.lancamento.CalcularValorPago;
import sis.apartamentos.com.br.domain.repository.ApartamentoRepository;
import sis.apartamentos.com.br.domain.repository.ControleLancamentoRepository;
import sis.apartamentos.com.br.infra.utils.Constantes;
import sis.apartamentos.com.br.infra.utils.Messages;

@Service
public class ControleLancamentoService {

    @Autowired
    private ControleLancamentoRepository controleLancamentoRepository;

    @Autowired
    private ApartamentoService apartamentoService;

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private CalculaDias calculaDias;

    @Autowired
    private CalcularValorPago calcularValorPago;

    @Autowired
    private ControleLancamentoMapper controleLancamentoMapper;

    @Autowired
    private CalculaValorDiaria calculaValoresDiaria;
    @Autowired
    private ApartamentoMapper apartamentoMapper;

    @Autowired
    private LancamentoProducerService emailProducer;

    @Autowired
    private PredioService predioService;

    @Autowired
    private InquilinoService inquilinoService;

    @Autowired
    private ControleLancamentorReportRepository controleLancamentorReportRepository;

    @Autowired
    private ControleLancamentoReportMapper controleLancamentoReportMapper;

    @SneakyThrows
    public ControleLancamento salvar(ControleLancamentoPostDTO controleLancamentoPostDTO) {
        var controleLancamento = controleLancamentoMapper.toControleLancamento(controleLancamentoPostDTO);
        var apartamento = BuscaApartamentos(controleLancamento);
        apartamento.setStatusApartamento(Constantes.OCUPADO);
        apartamentoRepository.save(apartamento);
        controleLancamento.getStatus().setStatusApartamePagamento(Constantes.DEBITO);
        calculaDias.calculaDia(controleLancamento);
        calculaValoresDiaria.calculaDiaria(controleLancamento);
        calcularValorPago.calcularValorPagoApartamento(controleLancamento);
        validaInquilinoEApartamentoPorDataDeEntrada(controleLancamento);

        controleLancamento.setDataLancamento(LocalDate.now());
        var controleLancamentoSalvo = controleLancamentoRepository.save(controleLancamento);
        var predio = predioService.buscarOuFalhar(apartamento.getPredio().getId());
        var inquilino = inquilinoService.buscarOuFalhar(controleLancamento.getInquilino().getId());
        toLancamentoProducer(controleLancamentoSalvo, apartamento, inquilino, predio);

        return controleLancamentoSalvo;
    }

    private void toLancamentoProducer(ControleLancamento controleLancamentoSalvo, Apartamento apartamento, Inquilino inquilino, Predio predio) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        var lancamentoApartamentoDTO = LancamentoApartamentoDTO.builder()
                .idLancamento(controleLancamentoSalvo.getId())
                .dataEntrada(controleLancamentoSalvo.getDataEntrada().format(formatter))
                .nomeInquilino(inquilino.getNome())
                .valor(controleLancamentoSalvo.getValores().getValorPagoApartamento().toString())
                .predio(predio.getNumero())
                .numeroQuarto(apartamento.getNumeroApartamento())
                .bairro(predio.getBairro())
                .cep(predio.getCep())
                .uf(predio.getUf())
                .localidade(predio.getLocalidade())
                .logradouro(predio.getLogradouro())
                .build();

        saveControleLancamentoToReport(lancamentoApartamentoDTO);

       // emailProducer.sendMessage(objectMapper.writeValueAsString(lancamentoApartamentoDTO));
    }

    private void saveControleLancamentoToReport(LancamentoApartamentoDTO lancamentoApartamentoDTO) {
        controleLancamentorReportRepository.save(controleLancamentoReportMapper.toControleLancamentoReport(lancamentoApartamentoDTO));
    }

    public ControleLancamento buscarOuFalhar(Long idControle) {
        return controleLancamentoRepository.findById(idControle)
                .orElseThrow(() -> new ControleLancamentoNaoEncontadoException(idControle));
    }

    public void excluir(Long idControle) {
        try {
            var lancamento = buscarOuFalhar(idControle);
            var apartamentoPutDTO = apartamentoMapper.toApartamentoPutDTO(lancamento.getApartamento());
            apartamentoService.atualizaStatusParaDisponivel(lancamento.getApartamento().getId(), apartamentoPutDTO);
            controleLancamentoRepository.deleteById(idControle);
            controleLancamentorReportRepository.deleteById(idControle);
            controleLancamentoRepository.flush();
        } catch (EmptyResultDataAccessException e) {
            throw new PredioNaoEncontadoException(idControle);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(Messages.MSG_CONTROLE_EM_USO, idControle));
        }
    }

    public void atualizarPropriedadeStatus(Long id) {

        var controleSalva = buscarOuFalhar(id);
        var apartamento = BuscaApartamentos(controleSalva);

        if (controleSalva.getStatus().getStatusApartamePagamento().equals(Constantes.PAGO)) {
            apartamento = BuscaApartamentos(controleSalva);
        } else {
            throw new EntidadeEmUsoException(String.format(Messages.MSG_APARTAMENTO_DEBITO, apartamento.getId()));
        }

        if (!controleSalva.getStatus().isStatusControle()) {
            apartamento.setStatusApartamento(Constantes.OCUPADO);
            controleSalva.getStatus().setStatusControle(true);
        } else if (controleSalva.getStatus().isStatusControle()) {
            controleSalva.getStatus().setStatusControle(false);
            apartamento.setStatusApartamento(Constantes.DISPONIVEL);
        }

        apartamentoRepository.save(apartamento);
        controleLancamentoRepository.save(controleSalva);
    }

    private Apartamento BuscaApartamentos(ControleLancamento controleSalva) {
        Long codigoApartamento = controleSalva.getApartamento().getId();
        return apartamentoService.buscarOuFalhar(codigoApartamento);

    }

    public ControleLancamento atualizar(Long idControle, ControleLancamentoPutDTO controleLancamentoPutDTO) {
        var controleLancamento = controleLancamentoMapper.toControleLancamento(controleLancamentoPutDTO);
        ControleLancamento controleLancamentoSalva = this.controleLancamentoRepository.findById(idControle)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        BeanUtils.copyProperties(controleLancamento, controleLancamentoSalva, "id");
        calculaDias.calculaDia(controleLancamento);
        calculaValoresDiaria.calculaDiaria(controleLancamento);
        calcularValorPago.calcularValorPagoApartamento(controleLancamento);
        return this.controleLancamentoRepository.save(controleLancamentoSalva);
    }

    public void validaInquilinoEApartamentoPorDataDeEntrada(ControleLancamento controleLancamento) {
        List<ControleLancamento> result = controleLancamentoRepository.listaControleLancamentosPorDataDeEntrada(
                controleLancamento.getInquilino().getId(), controleLancamento.getApartamento().getId(),
                controleLancamento.getDataEntrada(), controleLancamento.getDataPagamento());
        if (!result.isEmpty()) {
            throw new EntidadeEmUsoException(String.format(Messages.MSG_CONTROLE_INQUILINO_OU_APARTAMENTO_EM_USO));
        }
    }

    public byte[] relatorioDeLancamentos(Long idLancamento) {
        try {

            var dados = controleLancamentoRepository.buscarControlesLancamentos(idLancamento);
            var dataSource = new JRBeanCollectionDataSource(dados);

            var parametros = new HashMap<String, Object>();

            parametros.put("ID_LANCAMENTO", idLancamento);
            parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));

            var inputStream = this.getClass().getResourceAsStream("/relatorios/lancamentocontrolebyid.jasper");

            var jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            throw new ReportException("Não foi possível emitir relatório", e);
        }
    }

}
