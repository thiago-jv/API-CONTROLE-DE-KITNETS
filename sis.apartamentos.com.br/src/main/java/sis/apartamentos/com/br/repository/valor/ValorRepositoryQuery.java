package sis.apartamentos.com.br.repository.valor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

public interface ValorRepositoryQuery {

	Page<Valor> filtrar(ValorFilter valorFilter, Pageable pageable);
	
}
