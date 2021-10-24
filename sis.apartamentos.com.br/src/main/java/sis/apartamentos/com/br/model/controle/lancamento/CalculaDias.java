package sis.apartamentos.com.br.model.controle.lancamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.model.ControleLancamento;

@Component
public class CalculaDias {

	@Autowired
	private CalculaDiferencaEntreDatas diferencaDias;
	
	@Autowired
	private CalculaValoresDiaria calculaValorDiaria;
	
	public ControleLancamento calculaDia(ControleLancamento controleLancamento) {
		if(diferencaDias.calculaDia(controleLancamento) > 0) {
			controleLancamento.getValores().setDia(diferencaDias.calculaDia(controleLancamento) -1);
		}
		
	   calculaValorDiaria.valculaDiaria(controleLancamento);
       
		
		return controleLancamento;
	}
}
