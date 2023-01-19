package sis.apartamentos.com.br.domain.service.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.domain.service.comparacao.ComparaLancamentoData;

@Mapper(componentModel = "spring")
public interface ComparaDataMapper {

    ComparaLancamentoData toComparaLancamentoData(ControleLancamento controleLancamento);

}
