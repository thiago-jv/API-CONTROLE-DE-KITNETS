package sis.apartamentos.com.br.api.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoResponseDTO;
import sis.apartamentos.com.br.domain.model.ControleLancamento;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControleLancamentoMapper {

    ControleLancamento toControleLancamento(ControleLancamentoPostDTO controleLancamentoPostDTO);

    ControleLancamento toControleLancamento(ControleLancamentoPutDTO controleLancamentoPutDTO);

    ControleLancamentoResponseDTO toControleLancamentoResponse(ControleLancamento controleLancamento);

    List<ControleLancamentoResponseDTO> toListControleLancamentoResponse(List<ControleLancamento> controleLancamentos);
}
