package sis.apartamentos.com.br.domain.repository.apartamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.api.v1.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.domain.model.Apartamento;


public interface ApartamentoRepositoryQuery {
	
	Page<Apartamento> filtrar(ApartamentoFilterDTO apartamentoFilterDTO, Pageable pageable);

}
