package sis.apartamentos.com.br.controle.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoPostDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoPutDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoResponseDTO;
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InquilinoMapper {

    InquilinoFilter toInquilinoFilter(InquilinoFilterDTO inquilinoFilterDTO);

    Inquilino toInquilino(InquilinoPostDTO inquilinoPostDTO);

    Inquilino toInquilino(InquilinoPutDTO inquilinoPutDTO);

    InquilinoResponseDTO toInquilinoResponse(Inquilino inquilino);

    List<InquilinoResponseDTO> toListInquilinoResponse(List<Inquilino> inquilinos);
}
