package sis.apartamentos.com.br.repository.valor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.controle.v1.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.model.Valor;

public interface ValorRepositoryQuery {

	Page<Valor> filtrar(ValorFilterDTO valorFilterDTO, Pageable pageable);
	
}
