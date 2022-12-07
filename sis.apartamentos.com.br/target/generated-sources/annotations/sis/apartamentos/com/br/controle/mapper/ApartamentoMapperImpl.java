package sis.apartamentos.com.br.controle.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoPostDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoResponseDTO;
import sis.apartamentos.com.br.controle.dto.predio.PredioId;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T22:11:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ApartamentoMapperImpl implements ApartamentoMapper {

    @Override
    public ApartamentoFilter toApartamentoFilter(ApartamentoFilterDTO apartamentoFilterDTO) {
        if ( apartamentoFilterDTO == null ) {
            return null;
        }

        ApartamentoFilter apartamentoFilter = new ApartamentoFilter();

        apartamentoFilter.setDesricao( apartamentoFilterDTO.getDesricao() );
        apartamentoFilter.setNumero( apartamentoFilterDTO.getNumero() );
        apartamentoFilter.setStatusApartamento( apartamentoFilterDTO.getStatusApartamento() );

        return apartamentoFilter;
    }

    @Override
    public Apartamento toApartamento(ApartamentoPostDTO apartamentoPostDTO) {
        if ( apartamentoPostDTO == null ) {
            return null;
        }

        Apartamento apartamento = new Apartamento();

        apartamento.setNumero( apartamentoPostDTO.getNumero() );
        apartamento.setDescricao( apartamentoPostDTO.getDescricao() );
        apartamento.setMedidor( apartamentoPostDTO.getMedidor() );
        apartamento.setStatusApartamento( apartamentoPostDTO.getStatusApartamento() );
        apartamento.setPredio( predioIdToPredio( apartamentoPostDTO.getPredio() ) );

        return apartamento;
    }

    @Override
    public Apartamento toApartamento(ApartamentoPutDTO apartamentoPutDTO) {
        if ( apartamentoPutDTO == null ) {
            return null;
        }

        Apartamento apartamento = new Apartamento();

        apartamento.setId( apartamentoPutDTO.getId() );
        apartamento.setNumero( apartamentoPutDTO.getNumero() );
        apartamento.setDescricao( apartamentoPutDTO.getDescricao() );
        apartamento.setMedidor( apartamentoPutDTO.getMedidor() );
        apartamento.setStatusApartamento( apartamentoPutDTO.getStatusApartamento() );
        apartamento.setPredio( predioIdToPredio( apartamentoPutDTO.getPredio() ) );

        return apartamento;
    }

    @Override
    public ApartamentoResponseDTO toApartamentoResponse(Apartamento apartamento) {
        if ( apartamento == null ) {
            return null;
        }

        ApartamentoResponseDTO apartamentoResponseDTO = new ApartamentoResponseDTO();

        apartamentoResponseDTO.setId( apartamento.getId() );
        apartamentoResponseDTO.setNumero( apartamento.getNumero() );
        apartamentoResponseDTO.setDescricao( apartamento.getDescricao() );
        apartamentoResponseDTO.setMedidor( apartamento.getMedidor() );
        apartamentoResponseDTO.setStatusApartamento( apartamento.getStatusApartamento() );
        apartamentoResponseDTO.setPredio( predioToPredioId( apartamento.getPredio() ) );

        return apartamentoResponseDTO;
    }

    @Override
    public List<ApartamentoResponseDTO> toListApartamentoResponse(List<Apartamento> apartamentos) {
        if ( apartamentos == null ) {
            return null;
        }

        List<ApartamentoResponseDTO> list = new ArrayList<ApartamentoResponseDTO>( apartamentos.size() );
        for ( Apartamento apartamento : apartamentos ) {
            list.add( toApartamentoResponse( apartamento ) );
        }

        return list;
    }

    protected Predio predioIdToPredio(PredioId predioId) {
        if ( predioId == null ) {
            return null;
        }

        Predio predio = new Predio();

        predio.setId( predioId.getId() );

        return predio;
    }

    protected PredioId predioToPredioId(Predio predio) {
        if ( predio == null ) {
            return null;
        }

        PredioId predioId = new PredioId();

        predioId.setId( predio.getId() );

        return predioId;
    }
}
