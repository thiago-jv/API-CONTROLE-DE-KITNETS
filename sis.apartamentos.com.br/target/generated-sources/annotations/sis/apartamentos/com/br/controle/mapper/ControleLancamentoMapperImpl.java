package sis.apartamentos.com.br.controle.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoId;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoResponseDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.StatusDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ValorRegraDTO;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoId;
import sis.apartamentos.com.br.controle.dto.valor.ValorId;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.model.Status;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.model.ValorRegra;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T22:11:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ControleLancamentoMapperImpl implements ControleLancamentoMapper {

    @Override
    public ControleLancamento toControleLancamento(ControleLancamentoPostDTO controleLancamentoPostDTO) {
        if ( controleLancamentoPostDTO == null ) {
            return null;
        }

        ControleLancamento controleLancamento = new ControleLancamento();

        controleLancamento.setDataLancamento( controleLancamentoPostDTO.getDataLancamento() );
        controleLancamento.setDataEntrada( controleLancamentoPostDTO.getDataEntrada() );
        controleLancamento.setDataPagamento( controleLancamentoPostDTO.getDataPagamento() );
        controleLancamento.setObservacao( controleLancamentoPostDTO.getObservacao() );
        controleLancamento.setStatus( statusDTOToStatus( controleLancamentoPostDTO.getStatus() ) );
        controleLancamento.setValores( valorRegraDTOToValorRegra( controleLancamentoPostDTO.getValores() ) );
        controleLancamento.setValor( valorIdToValor( controleLancamentoPostDTO.getValor() ) );
        controleLancamento.setInquilino( inquilinoIdToInquilino( controleLancamentoPostDTO.getInquilino() ) );
        controleLancamento.setApartamento( apartamentoIdToApartamento( controleLancamentoPostDTO.getApartamento() ) );

        return controleLancamento;
    }

    @Override
    public ControleLancamento toControleLancamento(ControleLancamentoPutDTO controleLancamentoPutDTO) {
        if ( controleLancamentoPutDTO == null ) {
            return null;
        }

        ControleLancamento controleLancamento = new ControleLancamento();

        controleLancamento.setId( controleLancamentoPutDTO.getId() );
        controleLancamento.setDataLancamento( controleLancamentoPutDTO.getDataLancamento() );
        controleLancamento.setDataEntrada( controleLancamentoPutDTO.getDataEntrada() );
        controleLancamento.setDataPagamento( controleLancamentoPutDTO.getDataPagamento() );
        controleLancamento.setObservacao( controleLancamentoPutDTO.getObservacao() );
        controleLancamento.setStatus( statusDTOToStatus( controleLancamentoPutDTO.getStatus() ) );
        controleLancamento.setValores( valorRegraDTOToValorRegra( controleLancamentoPutDTO.getValores() ) );
        controleLancamento.setValor( valorIdToValor( controleLancamentoPutDTO.getValor() ) );
        controleLancamento.setInquilino( inquilinoIdToInquilino( controleLancamentoPutDTO.getInquilino() ) );
        controleLancamento.setApartamento( apartamentoIdToApartamento( controleLancamentoPutDTO.getApartamento() ) );

        return controleLancamento;
    }

    @Override
    public ControleLancamentoResponseDTO toControleLancamentoResponse(ControleLancamento controleLancamento) {
        if ( controleLancamento == null ) {
            return null;
        }

        ControleLancamentoResponseDTO controleLancamentoResponseDTO = new ControleLancamentoResponseDTO();

        controleLancamentoResponseDTO.setId( controleLancamento.getId() );
        controleLancamentoResponseDTO.setDataLancamento( controleLancamento.getDataLancamento() );
        controleLancamentoResponseDTO.setDataEntrada( controleLancamento.getDataEntrada() );
        controleLancamentoResponseDTO.setDataPagamento( controleLancamento.getDataPagamento() );
        controleLancamentoResponseDTO.setObservacao( controleLancamento.getObservacao() );
        controleLancamentoResponseDTO.setStatus( statusToStatusDTO( controleLancamento.getStatus() ) );
        controleLancamentoResponseDTO.setValores( valorRegraToValorRegraDTO( controleLancamento.getValores() ) );
        controleLancamentoResponseDTO.setValor( valorToValorId( controleLancamento.getValor() ) );
        controleLancamentoResponseDTO.setInquilino( inquilinoToInquilinoId( controleLancamento.getInquilino() ) );
        controleLancamentoResponseDTO.setApartamento( apartamentoToApartamentoId( controleLancamento.getApartamento() ) );

        return controleLancamentoResponseDTO;
    }

    @Override
    public List<ControleLancamentoResponseDTO> toListControleLancamentoResponse(List<ControleLancamento> controleLancamentos) {
        if ( controleLancamentos == null ) {
            return null;
        }

        List<ControleLancamentoResponseDTO> list = new ArrayList<ControleLancamentoResponseDTO>( controleLancamentos.size() );
        for ( ControleLancamento controleLancamento : controleLancamentos ) {
            list.add( toControleLancamentoResponse( controleLancamento ) );
        }

        return list;
    }

    protected Status statusDTOToStatus(StatusDTO statusDTO) {
        if ( statusDTO == null ) {
            return null;
        }

        Status status = new Status();

        status.setEntragaContaLuz( statusDTO.getEntragaContaLuz() );
        status.setStatusApartamePagamentoLuz( statusDTO.getStatusApartamePagamentoLuz() );
        status.setStatusApartamePagamento( statusDTO.getStatusApartamePagamento() );
        status.setStatusProximoPagamento( statusDTO.getStatusProximoPagamento() );
        status.setStatusControle( statusDTO.isStatusControle() );

        return status;
    }

    protected ValorRegra valorRegraDTOToValorRegra(ValorRegraDTO valorRegraDTO) {
        if ( valorRegraDTO == null ) {
            return null;
        }

        ValorRegra valorRegra = new ValorRegra();

        valorRegra.setValorTotalDiaria( valorRegraDTO.getValorTotalDiaria() );
        valorRegra.setValorDiaria( valorRegraDTO.getValorDiaria() );
        valorRegra.setValorPagoApartamento( valorRegraDTO.getValorPagoApartamento() );
        valorRegra.setValorApartamento( valorRegraDTO.getValorApartamento() );
        valorRegra.setValorDebitoApartamento( valorRegraDTO.getValorDebitoApartamento() );
        valorRegra.setDia( valorRegraDTO.getDia() );

        return valorRegra;
    }

    protected Valor valorIdToValor(ValorId valorId) {
        if ( valorId == null ) {
            return null;
        }

        Valor valor = new Valor();

        valor.setId( valorId.getId() );

        return valor;
    }

    protected Inquilino inquilinoIdToInquilino(InquilinoId inquilinoId) {
        if ( inquilinoId == null ) {
            return null;
        }

        Inquilino inquilino = new Inquilino();

        inquilino.setId( inquilinoId.getId() );

        return inquilino;
    }

    protected Apartamento apartamentoIdToApartamento(ApartamentoId apartamentoId) {
        if ( apartamentoId == null ) {
            return null;
        }

        Apartamento apartamento = new Apartamento();

        apartamento.setId( apartamentoId.getId() );

        return apartamento;
    }

    protected StatusDTO statusToStatusDTO(Status status) {
        if ( status == null ) {
            return null;
        }

        StatusDTO statusDTO = new StatusDTO();

        statusDTO.setEntragaContaLuz( status.getEntragaContaLuz() );
        statusDTO.setStatusApartamePagamentoLuz( status.getStatusApartamePagamentoLuz() );
        statusDTO.setStatusApartamePagamento( status.getStatusApartamePagamento() );
        statusDTO.setStatusProximoPagamento( status.getStatusProximoPagamento() );
        statusDTO.setStatusControle( status.isStatusControle() );

        return statusDTO;
    }

    protected ValorRegraDTO valorRegraToValorRegraDTO(ValorRegra valorRegra) {
        if ( valorRegra == null ) {
            return null;
        }

        ValorRegraDTO valorRegraDTO = new ValorRegraDTO();

        valorRegraDTO.setValorTotalDiaria( valorRegra.getValorTotalDiaria() );
        valorRegraDTO.setValorDiaria( valorRegra.getValorDiaria() );
        valorRegraDTO.setValorPagoApartamento( valorRegra.getValorPagoApartamento() );
        valorRegraDTO.setValorApartamento( valorRegra.getValorApartamento() );
        valorRegraDTO.setValorDebitoApartamento( valorRegra.getValorDebitoApartamento() );
        valorRegraDTO.setDia( valorRegra.getDia() );

        return valorRegraDTO;
    }

    protected ValorId valorToValorId(Valor valor) {
        if ( valor == null ) {
            return null;
        }

        ValorId valorId = new ValorId();

        valorId.setId( valor.getId() );

        return valorId;
    }

    protected InquilinoId inquilinoToInquilinoId(Inquilino inquilino) {
        if ( inquilino == null ) {
            return null;
        }

        InquilinoId inquilinoId = new InquilinoId();

        inquilinoId.setId( inquilino.getId() );

        return inquilinoId;
    }

    protected ApartamentoId apartamentoToApartamentoId(Apartamento apartamento) {
        if ( apartamento == null ) {
            return null;
        }

        ApartamentoId apartamentoId = new ApartamentoId();

        apartamentoId.setId( apartamento.getId() );

        return apartamentoId;
    }
}
