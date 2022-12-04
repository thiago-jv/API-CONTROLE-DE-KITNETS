package sis.apartamentos.com.br.repository.predio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.controle.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.filter.PredioFilter;

public interface PredioRepositoryQuery {

	Page<Predio> filtrar(PredioFilterDTO predioFilterDTO, Pageable pageable);
	
}
