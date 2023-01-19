package sis.apartamentos.com.br.domain.repository.inquilino;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.domain.model.Inquilino;

public interface InquilinoRepositoryQuery {
	
	Page<Inquilino> filtrar(InquilinoFilterDTO inquilinoFilterDTO, Pageable pageable);

}
