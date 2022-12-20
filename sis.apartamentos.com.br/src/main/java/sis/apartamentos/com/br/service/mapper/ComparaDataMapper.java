package sis.apartamentos.com.br.service.mapper;

import org.mapstruct.Mapper;
import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.service.comparacao.ComparaLancamentoData;

@Mapper(componentModel = "spring")
public interface ComparaDataMapper {

    ComparaLancamentoData toComparaLancamentoData(ControleLancamento controleLancamento);

}
