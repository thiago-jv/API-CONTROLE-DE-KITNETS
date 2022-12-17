package sis.apartamentos.com.br.controle.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.controle.v1.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.controle.v1.dto.valor.ValorPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.valor.ValorResponseDTO;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ValorMapper {

    ValorFilter toValorFilter(ValorFilterDTO valorFilterDTO);

    Valor toValor(ValorPostDTO valorDTO);

    Valor toValor(ValorPutDTO valorDTO);

    ValorResponseDTO toValorResponse(Valor valor);

    List<ValorResponseDTO> toListValorResponse(List<Valor> valors);

}
