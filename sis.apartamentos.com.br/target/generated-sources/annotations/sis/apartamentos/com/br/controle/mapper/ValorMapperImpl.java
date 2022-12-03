package sis.apartamentos.com.br.controle.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.dto.ValorFilterDTO;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T19:39:39-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ValorMapperImpl implements ValorMapper {

    @Override
    public ValorFilter toValor(ValorFilterDTO valorFilterDTO) {
        if ( valorFilterDTO == null ) {
            return null;
        }

        ValorFilter valorFilter = new ValorFilter();

        valorFilter.setValor( valorFilterDTO.getValor() );

        return valorFilter;
    }
}
