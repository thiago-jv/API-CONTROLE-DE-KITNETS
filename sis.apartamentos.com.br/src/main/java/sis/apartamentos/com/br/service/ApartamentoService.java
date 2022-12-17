package sis.apartamentos.com.br.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.v1.mapper.ApartamentoMapper;
import sis.apartamentos.com.br.exception.ApartamentoNaoEncontadoException;
import sis.apartamentos.com.br.exception.EntidadeEmUsoException;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.ApartamentoRepository;
import sis.apartamentos.com.br.utils.Constantes;
import sis.apartamentos.com.br.utils.Messages;

import java.io.Serializable;

@Service
public class ApartamentoService implements Serializable {

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	@Autowired
	private ApartamentoMapper apartamentoMapper;

	public Apartamento buscarOuFalhar(Long idApartamento) {
		return apartamentoRepository.findById(idApartamento).orElseThrow(() -> new ApartamentoNaoEncontadoException(idApartamento));
	}
	
	public void excluir(Long idApartamento) {
		try {
			apartamentoRepository.deleteById(idApartamento);
			apartamentoRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new ApartamentoNaoEncontadoException(idApartamento);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(Messages.MSG_APARTAMENTO_EM_USO, idApartamento));
		}
	}
	
	public Apartamento atualizar(Long idApartamento, ApartamentoPutDTO apartamentoPutDTO) {
		Apartamento apartamento = apartamentoMapper.toApartamento(apartamentoPutDTO);
		Apartamento apartamentoSalva = this.apartamentoRepository.findById(idApartamento)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(apartamento, apartamentoSalva, "id");
		return this.apartamentoRepository.save(apartamentoSalva);
	}

	public Apartamento atualizaStatusParaDisponivel(Long idApartamento, ApartamentoPutDTO apartamentoPutDTO) {
		apartamentoPutDTO.setStatusApartamento(Constantes.DISPONIVEL);
		Apartamento apartamento = apartamentoMapper.toApartamento(apartamentoPutDTO);
		Apartamento apartamentoSalva = this.apartamentoRepository.findById(idApartamento)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(apartamento, apartamentoSalva, "id");
		return this.apartamentoRepository.save(apartamentoSalva);
	}

}
