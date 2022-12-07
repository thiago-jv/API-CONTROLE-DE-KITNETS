package sis.apartamentos.com.br.repository.apartamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.model.Apartamento;


public interface ApartamentoRepositoryQuery {
	
	Page<Apartamento> filtrar(ApartamentoFilterDTO apartamentoFilterDTO, Pageable pageable);

}
