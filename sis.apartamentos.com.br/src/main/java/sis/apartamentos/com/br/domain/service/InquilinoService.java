package sis.apartamentos.com.br.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoPutDTO;
import sis.apartamentos.com.br.api.v1.mapper.InquilinoMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.infra.exception.InquilinoNaoEncontadoException;
import sis.apartamentos.com.br.infra.exception.PredioNaoEncontadoException;
import sis.apartamentos.com.br.domain.model.Inquilino;
import sis.apartamentos.com.br.domain.repository.InquilinoRepository;
import sis.apartamentos.com.br.infra.utils.Messages;

@Service
public class InquilinoService {

	@Autowired
	private InquilinoRepository inquilinoRepository;

	@Autowired
	private InquilinoMapper inquilinoMapper;

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
	
	public Inquilino atualizar(Long idInquilino, InquilinoPutDTO inquilinoPutDTO) {
		var inquilino = inquilinoMapper.toInquilino(inquilinoPutDTO);
		var inquilinoSalva = this.inquilinoRepository.findById(idInquilino)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(inquilino, inquilinoSalva, "id");
		return this.inquilinoRepository.save(inquilinoSalva);
	}
	
}
