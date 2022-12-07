package sis.apartamentos.com.br.controle.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoPostDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoPutDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoResponseDTO;
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T22:11:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class InquilinoMapperImpl implements InquilinoMapper {

    @Override
    public InquilinoFilter toInquilinoFilter(InquilinoFilterDTO inquilinoFilterDTO) {
        if ( inquilinoFilterDTO == null ) {
            return null;
        }

        InquilinoFilter inquilinoFilter = new InquilinoFilter();

        inquilinoFilter.setNome( inquilinoFilterDTO.getNome() );
        inquilinoFilter.setCpf( inquilinoFilterDTO.getCpf() );
        inquilinoFilter.setStatus( inquilinoFilterDTO.getStatus() );

        return inquilinoFilter;
    }

    @Override
    public Inquilino toInquilino(InquilinoPostDTO inquilinoPostDTO) {
        if ( inquilinoPostDTO == null ) {
            return null;
        }

        Inquilino inquilino = new Inquilino();

        inquilino.setId( inquilinoPostDTO.getId() );
        inquilino.setNome( inquilinoPostDTO.getNome() );
        inquilino.setNomeAbreviado( inquilinoPostDTO.getNomeAbreviado() );
        inquilino.setEmail( inquilinoPostDTO.getEmail() );
        inquilino.setContato( inquilinoPostDTO.getContato() );
        inquilino.setStatus( inquilinoPostDTO.getStatus() );
        inquilino.setGenero( inquilinoPostDTO.getGenero() );
        inquilino.setCpf( inquilinoPostDTO.getCpf() );

        return inquilino;
    }

    @Override
    public Inquilino toInquilino(InquilinoPutDTO inquilinoPutDTO) {
        if ( inquilinoPutDTO == null ) {
            return null;
        }

        Inquilino inquilino = new Inquilino();

        inquilino.setId( inquilinoPutDTO.getId() );
        inquilino.setNome( inquilinoPutDTO.getNome() );
        inquilino.setNomeAbreviado( inquilinoPutDTO.getNomeAbreviado() );
        inquilino.setEmail( inquilinoPutDTO.getEmail() );
        inquilino.setContato( inquilinoPutDTO.getContato() );
        inquilino.setStatus( inquilinoPutDTO.getStatus() );
        inquilino.setGenero( inquilinoPutDTO.getGenero() );
        inquilino.setCpf( inquilinoPutDTO.getCpf() );

        return inquilino;
    }

    @Override
    public InquilinoResponseDTO toInquilinoResponse(Inquilino inquilino) {
        if ( inquilino == null ) {
            return null;
        }

        InquilinoResponseDTO inquilinoResponseDTO = new InquilinoResponseDTO();

        inquilinoResponseDTO.setId( inquilino.getId() );
        inquilinoResponseDTO.setNome( inquilino.getNome() );
        inquilinoResponseDTO.setNomeAbreviado( inquilino.getNomeAbreviado() );
        inquilinoResponseDTO.setEmail( inquilino.getEmail() );
        inquilinoResponseDTO.setContato( inquilino.getContato() );
        inquilinoResponseDTO.setStatus( inquilino.getStatus() );
        inquilinoResponseDTO.setGenero( inquilino.getGenero() );
        inquilinoResponseDTO.setCpf( inquilino.getCpf() );

        return inquilinoResponseDTO;
    }

    @Override
    public List<InquilinoResponseDTO> toListInquilinoResponse(List<Inquilino> inquilinos) {
        if ( inquilinos == null ) {
            return null;
        }

        List<InquilinoResponseDTO> list = new ArrayList<InquilinoResponseDTO>( inquilinos.size() );
        for ( Inquilino inquilino : inquilinos ) {
            list.add( toInquilinoResponse( inquilino ) );
        }

        return list;
    }
}
