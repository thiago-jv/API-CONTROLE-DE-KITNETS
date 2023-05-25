package sis.apartamentos.com.br.api.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.api.v1.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.predio.PredioPostDTO;
import sis.apartamentos.com.br.api.v1.dto.predio.PredioPutDTO;
import sis.apartamentos.com.br.api.v1.dto.predio.PredioResponseDTO;
import sis.apartamentos.com.br.domain.model.Predio;
import sis.apartamentos.com.br.domain.repository.filter.PredioFilter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PredioMapper {

    PredioFilter toPredioFilter(PredioFilterDTO predioFilterDTO);

    Predio toPredio(PredioPostDTO predioPostDTO);

    Predio toPredio(PredioPutDTO predioPutDTO);

    PredioResponseDTO toPredioResponse(Predio predio);

    List<PredioResponseDTO> toListPredioResponse(List<Predio> predios);

}
