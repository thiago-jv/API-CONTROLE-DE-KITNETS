package sis.apartamentos.com.br.controle.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.controle.dto.ValorFilterDTO;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

@Mapper(componentModel = "spring")
public interface ValorMapper {

    ValorFilter toValor(ValorFilterDTO valorFilterDTO);
}
