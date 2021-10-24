package sis.apartamentos.com.br.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.exception.ControleLancamentoNaoEncontadoException;
import sis.apartamentos.com.br.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.exception.PredioNaoEncontadoException;
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

	public ControleLancamento salvar(ControleLancamento controleLancamento) {
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
		
		if(controleSalva.getStatus().getStatusApartamePagamento() == Constantes.PAGO) {
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
		Apartamento apartamento = apartamentoService.buscarOuFalhar(codigoApartamento);
		return apartamento;
	}
	
	public ControleLancamento atualizar(Long idControle, ControleLancamento controleLancamento) {
		ControleLancamento controleLancamentoSalva = this.controleLancamentoRepository.findById(idControle)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(controleLancamento, controleLancamentoSalva, "id");
		calculaDias.calculaDia(controleLancamentoSalva);
		calcularValorPago.calcularValorPagoApartamento(controleLancamentoSalva);
		return this.controleLancamentoRepository.save(controleLancamentoSalva);
	}


	public void listaPorDataDeEntrada(ControleLancamento controleLancamento) {
/*		List<ControleLancamento> result = controleLancamentoRepository.listaControleLancamentosPorDataDeEntrada(
				controleLancamento.getInquilino().getId(), controleLancamento.getApartamento().getId(),
				controleLancamento.getDataEntrada(), controleLancamento.getDataPagamento());
		if (!result.isEmpty()) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_CONTROLE_INQUILINO_OU_APARTAMENTO_EM_USO));
		}*/
	}
	
}
