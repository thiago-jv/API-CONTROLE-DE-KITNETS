package sis.apartamentos.com.br.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.api.v1.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.api.v1.mapper.ValorMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.infra.exception.ValorNaoEncontadoException;
import sis.apartamentos.com.br.domain.model.Valor;
import sis.apartamentos.com.br.domain.repository.ValorRepository;
import sis.apartamentos.com.br.infra.utils.Messages;

@Service
public class ValorService {

	@Autowired
	private ValorRepository valorRepository;

	@Autowired
	private ValorMapper valorMapper;

	public Valor buscarOuFalhar(Long idValor) {
		return valorRepository.findById(idValor).orElseThrow(() -> new ValorNaoEncontadoException(idValor));
	}
	
	public void excluir(Long idValor) {
		try {
			valorRepository.deleteById(idValor);
			valorRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new ValorNaoEncontadoException(idValor);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_VALOR_EM_USO, idValor));
		}
	}
	
	public Valor atualizar(Long idValor, ValorPutDTO valorPutDTO) {
		var valor = valorMapper.toValor(valorPutDTO);
		var valorSalva = this.valorRepository.findById(idValor)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(valor, valorSalva, "id");
		return this.valorRepository.save(valorSalva);
	}
	
}

