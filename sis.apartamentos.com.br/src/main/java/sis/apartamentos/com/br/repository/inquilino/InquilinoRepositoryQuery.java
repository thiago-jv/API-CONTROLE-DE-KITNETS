package sis.apartamentos.com.br.repository.inquilino;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.model.Inquilino;

public interface InquilinoRepositoryQuery {
	
	Page<Inquilino> filtrar(InquilinoFilterDTO inquilinoFilterDTO, Pageable pageable);

}
