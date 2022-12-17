package sis.apartamentos.com.br.controle.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoResponseDTO;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartamentoMapper {

    ApartamentoFilter toApartamentoFilter(ApartamentoFilterDTO apartamentoFilterDTO);

    Apartamento toApartamento(ApartamentoPostDTO apartamentoPostDTO);

    ApartamentoPutDTO toApartamentoPutDTO(Apartamento apartamento);

    Apartamento toApartamento(ApartamentoPutDTO apartamentoPutDTO);

    ApartamentoResponseDTO toApartamentoResponse(Apartamento apartamento);

    List<ApartamentoResponseDTO> toListApartamentoResponse(List<Apartamento> apartamentos);
}
