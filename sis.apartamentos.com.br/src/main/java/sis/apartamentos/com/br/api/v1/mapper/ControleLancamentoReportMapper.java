package sis.apartamentos.com.br.api.v1.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.domain.model.report.ControleLancamentoReport;
import sis.apartamentos.com.br.infra.dto.LancamentoApartamentoDTO;

@Mapper(componentModel = "spring")
public interface ControleLancamentoReportMapper {

    ControleLancamentoReport toControleLancamentoReport(LancamentoApartamentoDTO lancamentoApartamentoDTO);

}
