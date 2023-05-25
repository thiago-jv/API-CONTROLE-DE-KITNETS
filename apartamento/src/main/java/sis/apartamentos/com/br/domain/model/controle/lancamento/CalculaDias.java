package sis.apartamentos.com.br.domain.model.controle.lancamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.domain.service.mapper.ComparaDataMapper;

@Component
public class CalculaDias {

	@Autowired
	private CalculaDiferencaEntreDatas diferencaDias;

	@Autowired
	private ComparaDataMapper comparaDataMapper;


	public ControleLancamento calculaDia(ControleLancamento controleLancamento) {
		var comparaLancamentoData = comparaDataMapper.toComparaLancamentoData(controleLancamento);

		if(diferencaDias.calculaDia(controleLancamento) > 0) {
			controleLancamento.getValores().setDia(diferencaDias.calculaDia(controleLancamento));
		}

		if(comparaLancamentoData.getDataEntrada().equals(comparaLancamentoData.getDataPagamento())){
			controleLancamento.getValores().setDia( Long.valueOf(1));
		}
		return controleLancamento;
	}
}
