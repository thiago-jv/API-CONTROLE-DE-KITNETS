package sis.apartamentos.com.br.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.api.v1.dto.predio.PredioPutDTO;
import sis.apartamentos.com.br.api.v1.mapper.PredioMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.infra.exception.PredioNaoEncontadoException;
import sis.apartamentos.com.br.domain.model.Predio;
import sis.apartamentos.com.br.domain.repository.PredioRepository;
import sis.apartamentos.com.br.infra.utils.Messages;

@Service
public class PredioService {

	@Autowired
	private PredioRepository predioRepository;

	@Autowired
	private PredioMapper predioMapper;
	
	public Predio buscarOuFalhar(Long idPredio) {
		return predioRepository.findById(idPredio).orElseThrow(() -> new PredioNaoEncontadoException(idPredio));
	}
	
	public void excluir(Long idPredio) {
		try {
			predioRepository.deleteById(idPredio);
			predioRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PredioNaoEncontadoException(idPredio);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_PREDIO_EM_USO, idPredio));
		}
	}
	
	public Predio atualizar(Long idPredio, PredioPutDTO predioPutDTO) {
		Predio predio  = predioMapper.toPredio(predioPutDTO);
		Predio predioSalva = this.predioRepository.findById(idPredio)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(predio, predioSalva, "id");
		return this.predioRepository.save(predioSalva);
	}

	
}
