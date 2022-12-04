package sis.apartamentos.com.br.controle.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorPostDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorResponseDTO;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-04T11:00:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ValorMapperImpl implements ValorMapper {

    @Override
    public ValorFilter toValorFilter(ValorFilterDTO valorFilterDTO) {
        if ( valorFilterDTO == null ) {
            return null;
        }

        ValorFilter valorFilter = new ValorFilter();

        valorFilter.setValor( valorFilterDTO.getValor() );

        return valorFilter;
    }

    @Override
    public Valor toValor(ValorPostDTO valorDTO) {
        if ( valorDTO == null ) {
            return null;
        }

        Valor valor = new Valor();

        valor.setValor( valorDTO.getValor() );

        return valor;
    }

    @Override
    public Valor toValor(ValorPutDTO valorDTO) {
        if ( valorDTO == null ) {
            return null;
        }

        Valor valor = new Valor();

        valor.setId( valorDTO.getId() );
        valor.setValor( valorDTO.getValor() );

        return valor;
    }

    @Override
    public ValorResponseDTO toValorResponse(Valor valor) {
        if ( valor == null ) {
            return null;
        }

        ValorResponseDTO valorResponseDTO = new ValorResponseDTO();

        valorResponseDTO.setId( valor.getId() );
        valorResponseDTO.setValor( valor.getValor() );

        return valorResponseDTO;
    }

    @Override
    public List<ValorResponseDTO> toListValorResponse(List<Valor> valors) {
        if ( valors == null ) {
            return null;
        }

        List<ValorResponseDTO> list = new ArrayList<ValorResponseDTO>( valors.size() );
        for ( Valor valor : valors ) {
            list.add( toValorResponse( valor ) );
        }

        return list;
    }
}
