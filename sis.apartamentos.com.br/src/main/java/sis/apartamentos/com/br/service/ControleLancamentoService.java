package sis.apartamentos.com.br.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.controle.v1.mapper.ApartamentoMapper;
import sis.apartamentos.com.br.controle.v1.mapper.ControleLancamentoMapper;
import sis.apartamentos.com.br.exception.ControleLancamentoNaoEncontadoException;
import sis.apartamentos.com.br.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.exception.PredioNaoEncontadoException;
import sis.apartamentos.com.br.exception.ReportException;
import sis.apartamentos.com.br.filter.LancamentoControleFilter;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.model.controle.lancamento.CalculaDias;
import sis.apartamentos.com.br.model.controle.lancamento.CalcularValorPago;
import sis.apartamentos.com.br.repository.ApartamentoRepository;
import sis.apartamentos.com.br.repository.ControleLancamentoRepository;
import sis.apartamentos.com.br.utils.Constantes;
import sis.apartamentos.com.br.utils.Messages;

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
	private ApartamentoMapper apartamentoMapper;

	public ControleLancamento salvar(ControleLancamentoPostDTO controleLancamentoPostDTO) {
        var controleLancamento = controleLancamentoMapper.toControleLancamento(controleLancamentoPostDTO);
		Apartamento apartamento = BuscaApartamentos(controleLancamento);
		apartamento.setStatusApartamento(Constantes.OCUPADO);
		apartamentoRepository.save(apartamento);
		controleLancamento.getStatus().setStatusApartamePagamento(Constantes.DEBITO);
		calculaDias.calculaDia(controleLancamento);
		calcularValorPago.calcularValorPagoApartamento(controleLancamento);
		listaPorDataDeEntrada(controleLancamento);
		return controleLancamentoRepository.save(controleLancamento);
	}

	public ControleLancamento buscarOuFalhar(Long idControle) {
		return controleLancamentoRepository.findById(idControle)
				.orElseThrow(() -> new ControleLancamentoNaoEncontadoException(idControle));
	}

	public void excluir(Long idControle) {
		try {
			var lancamento = buscarOuFalhar(idControle);
			var apartamento = apartamentoService.buscarOuFalhar(lancamento.getApartamento().getId());
			var apartamentoPutDTO = apartamentoMapper.toApartamentoPutDTO(lancamento.getApartamento());
			apartamentoService.atualizaStatusParaDisponivel(lancamento.getApartamento().getId(), apartamentoPutDTO);
			controleLancamentoRepository.deleteById(idControle);
			controleLancamentoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PredioNaoEncontadoException(idControle);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_CONTROLE_EM_USO, idControle));
		}
	}

	public void atualizarPropriedadeStatus(Long id) {

		ControleLancamento controleSalva = buscarOuFalhar(id);
		Apartamento apartamento = BuscaApartamentos(controleSalva);
		
		if(controleSalva.getStatus().getStatusApartamePagamento().equals(Constantes.PAGO)) {
		    apartamento = BuscaApartamentos(controleSalva);	
		} else {
		    throw new EntidadeEmUsoException(String.format(Messages.MSG_APARTAMENTO_DEBITO, apartamento.getId()));
		}
		
		if (!controleSalva.getStatus().isStatusControle()) {
			apartamento.setStatusApartamento(Constantes.OCUPADO);
			controleSalva.getStatus().setStatusControle(true);
		} else if(controleSalva.getStatus().isStatusControle()) {
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
		calculaDias.calculaDia(controleLancamentoSalva);
		calcularValorPago.calcularValorPagoApartamento(controleLancamentoSalva);
		return this.controleLancamentoRepository.save(controleLancamentoSalva);
	}


	public void listaPorDataDeEntrada(ControleLancamento controleLancamento) {
		List<ControleLancamento> result = controleLancamentoRepository.listaControleLancamentosPorDataDeEntrada(
				controleLancamento.getInquilino().getId(), controleLancamento.getApartamento().getId(),
				controleLancamento.getDataEntrada(), controleLancamento.getDataPagamento());
		if (!result.isEmpty()) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_CONTROLE_INQUILINO_OU_APARTAMENTO_EM_USO));
		}
	}
	
	public byte[] relatorioDeLancamentos(LancamentoControleFilter filtro ) throws JRException {
		try {
			
			var inputStream = this.getClass().getResourceAsStream("/relatorios/lancamentosControle.jasper");
			var parametros = new HashMap<String, Object>();
			
			parametros.put("DT_INICIO", Date.valueOf(filtro.getDataInicio()));
			parametros.put("DT_FIM", Date.valueOf(filtro.getDataFim()));
			parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
			
			var dados = controleLancamentoRepository.buscarControlesLancamentos(filtro);
			var dataSource = new JRBeanCollectionDataSource(dados);
			
			var jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);
			
			return JasperExportManager.exportReportToPdf(jasperPrint);
		}catch (Exception e) {
			throw new ReportException("Não foi possível emitir relatório", e);
		}
	}
	
}
