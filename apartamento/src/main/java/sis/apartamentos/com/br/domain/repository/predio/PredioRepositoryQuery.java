package sis.apartamentos.com.br.domain.repository.predio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.api.v1.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.domain.model.Predio;

public interface PredioRepositoryQuery {

	Page<Predio> filtrar(PredioFilterDTO predioFilterDTO, Pageable pageable);
	
}
