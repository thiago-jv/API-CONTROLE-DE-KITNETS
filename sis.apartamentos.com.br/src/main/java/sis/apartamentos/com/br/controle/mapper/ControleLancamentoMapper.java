package sis.apartamentos.com.br.controle.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.controle.dto.controleLancamento.ControleLancamentoResponseDTO;
import sis.apartamentos.com.br.model.ControleLancamento;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ControleLancamentoMapper {

    ControleLancamento toControleLancamento(ControleLancamentoPostDTO controleLancamentoPostDTO);

    ControleLancamento toControleLancamento(ControleLancamentoPutDTO controleLancamentoPutDTO);

    ControleLancamentoResponseDTO toControleLancamentoResponse(ControleLancamento controleLancamento);

    List<ControleLancamentoResponseDTO> toListControleLancamentoResponse(List<ControleLancamento> controleLancamentos);
}
