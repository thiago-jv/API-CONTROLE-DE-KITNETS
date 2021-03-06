package sis.apartamentos.com.br.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.exception.InquilinoNaoEncontadoException;
import sis.apartamentos.com.br.exception.PredioNaoEncontadoException;
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.InquilinoRepository;
import sis.apartamentos.com.br.utils.Messages;

@Service
public class InquilinoService {

	@Autowired
	private InquilinoRepository inquilinoRepository;

	public Inquilino buscarOuFalhar(Long idInquilino) {
		return inquilinoRepository.findById(idInquilino).orElseThrow(() -> new InquilinoNaoEncontadoException(idInquilino));
	}
	
	public void excluir(Long idInquilino) {
		try {
			inquilinoRepository.deleteById(idInquilino);
			inquilinoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new PredioNaoEncontadoException(idInquilino);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_INQUILINO_EM_USO, idInquilino));
		}
	}
	
	public Inquilino atualizar(Long idInquilino, Inquilino inquilino) {
		Inquilino inquilinoSalva = this.inquilinoRepository.findById(idInquilino)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(inquilino, inquilinoSalva, "id");
		return this.inquilinoRepository.save(inquilinoSalva);
	}
	
}
