package sis.apartamentos.com.br.domain.repository.diario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioFilterDTO;
import sis.apartamentos.com.br.domain.model.Diario;

public interface DiarioRepositoryQuery {

    Page<Diario> filtrar(DiarioFilterDTO diarioFilterDTO, Pageable pageable);
}
