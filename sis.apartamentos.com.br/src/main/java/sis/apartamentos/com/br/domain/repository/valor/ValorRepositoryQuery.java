package sis.apartamentos.com.br.domain.repository.valor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.api.v1.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.domain.model.Valor;

public interface ValorRepositoryQuery {

	Page<Valor> filtrar(ValorFilterDTO valorFilterDTO, Pageable pageable);
	
}
