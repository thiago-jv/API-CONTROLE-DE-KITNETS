package sis.apartamentos.com.br.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.exception.ValorNaoEncontadoException;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.ValorRepository;
import sis.apartamentos.com.br.utils.Messages;

@Service
public class ValorService {

	@Autowired
	private ValorRepository valorRepository;

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
	
	public Valor atualizar(Long idValor, Valor valor) {
		Valor valorSalva = this.valorRepository.findById(idValor)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(valor, valorSalva, "id");
		return this.valorRepository.save(valorSalva);
	}
	
}

