package sis.apartamentos.com.br.repository.apartamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;


public interface ApartamentoRepositoryQuery {
	
	Page<Apartamento> filtrar(ApartamentoFilter apartamentoFilter, Pageable pageable);

}
