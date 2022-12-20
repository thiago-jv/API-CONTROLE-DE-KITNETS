package sis.apartamentos.com.br.service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.service.comparacao.ComparaLancamentoData;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-19T20:44:03-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class ComparaDataMapperImpl implements ComparaDataMapper {

    @Override
    public ComparaLancamentoData toComparaLancamentoData(ControleLancamento controleLancamento) {
        if ( controleLancamento == null ) {
            return null;
        }

        ComparaLancamentoData comparaLancamentoData = new ComparaLancamentoData();

        comparaLancamentoData.setDataEntrada( controleLancamento.getDataEntrada() );
        comparaLancamentoData.setDataPagamento( controleLancamento.getDataPagamento() );

        return comparaLancamentoData;
    }
}
