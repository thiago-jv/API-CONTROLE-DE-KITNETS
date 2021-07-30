package sis.apartamentos.com.br.repository.inquilino;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;

public interface InquilinoRepositoryQuery {
	
	Page<Inquilino> filtrar(InquilinoFilter inquilinoFilter, Pageable pageable);

}
