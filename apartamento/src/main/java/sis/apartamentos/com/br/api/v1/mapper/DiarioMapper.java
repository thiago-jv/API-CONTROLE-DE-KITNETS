package sis.apartamentos.com.br.api.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioPostDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioResponseDTO;
import sis.apartamentos.com.br.domain.model.Diario;
import sis.apartamentos.com.br.domain.repository.filter.DiarioFilter;

@Mapper(componentModel = "spring")
public interface DiarioMapper {

    DiarioFilter toDiarioFilterDTO(DiarioFilterDTO diarioFilterDTO);
    Diario toDiario(DiarioPostDTO diarioPostDTO);

    DiarioResponseDTO toDiarioResponseDTO(Diario diario);
}
