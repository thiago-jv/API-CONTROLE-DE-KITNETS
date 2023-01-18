package sis.apartamentos.com.br.controle.v1.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioResponseDTO;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.filter.PredioFilter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-18T18:12:34-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class PredioMapperImpl implements PredioMapper {

    @Override
    public PredioFilter toPredioFilter(PredioFilterDTO predioFilterDTO) {
        if ( predioFilterDTO == null ) {
            return null;
        }

        PredioFilter predioFilter = new PredioFilter();

        predioFilter.setDescricao( predioFilterDTO.getDescricao() );

        return predioFilter;
    }

    @Override
    public Predio toPredio(PredioPostDTO predioPostDTO) {
        if ( predioPostDTO == null ) {
            return null;
        }

        Predio predio = new Predio();

        predio.setDescricao( predioPostDTO.getDescricao() );
        predio.setCep( predioPostDTO.getCep() );
        predio.setLogradouro( predioPostDTO.getLogradouro() );
        predio.setComplemento( predioPostDTO.getComplemento() );
        predio.setBairro( predioPostDTO.getBairro() );
        predio.setUf( predioPostDTO.getUf() );
        predio.setLocalidade( predioPostDTO.getLocalidade() );
        predio.setNumero( predioPostDTO.getNumero() );

        return predio;
    }

    @Override
    public Predio toPredio(PredioPutDTO predioPutDTO) {
        if ( predioPutDTO == null ) {
            return null;
        }

        Predio predio = new Predio();

        predio.setId( predioPutDTO.getId() );
        predio.setDescricao( predioPutDTO.getDescricao() );
        predio.setCep( predioPutDTO.getCep() );
        predio.setLogradouro( predioPutDTO.getLogradouro() );
        predio.setComplemento( predioPutDTO.getComplemento() );
        predio.setBairro( predioPutDTO.getBairro() );
        predio.setUf( predioPutDTO.getUf() );
        predio.setLocalidade( predioPutDTO.getLocalidade() );
        predio.setNumero( predioPutDTO.getNumero() );

        return predio;
    }

    @Override
    public PredioResponseDTO toPredioResponse(Predio predio) {
        if ( predio == null ) {
            return null;
        }

        PredioResponseDTO predioResponseDTO = new PredioResponseDTO();

        predioResponseDTO.setId( predio.getId() );
        predioResponseDTO.setDescricao( predio.getDescricao() );
        predioResponseDTO.setCep( predio.getCep() );
        predioResponseDTO.setLogradouro( predio.getLogradouro() );
        predioResponseDTO.setComplemento( predio.getComplemento() );
        predioResponseDTO.setBairro( predio.getBairro() );
        predioResponseDTO.setUf( predio.getUf() );
        predioResponseDTO.setLocalidade( predio.getLocalidade() );
        predioResponseDTO.setNumero( predio.getNumero() );

        return predioResponseDTO;
    }

    @Override
    public List<PredioResponseDTO> toListPredioResponse(List<Predio> predios) {
        if ( predios == null ) {
            return null;
        }

        List<PredioResponseDTO> list = new ArrayList<PredioResponseDTO>( predios.size() );
        for ( Predio predio : predios ) {
            list.add( toPredioResponse( predio ) );
        }

        return list;
    }
}
