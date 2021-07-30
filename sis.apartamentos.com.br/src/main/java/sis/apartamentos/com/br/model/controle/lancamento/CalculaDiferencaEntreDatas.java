package sis.apartamentos.com.br.model.controle.lancamento;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.model.ControleLancamento;

@Component
public class CalculaDiferencaEntreDatas {
	
	public Long calculaDia(ControleLancamento controleLancamento) {
		long diferencaDias = ChronoUnit.DAYS.between(controleLancamento.getDataEntrada(), controleLancamento.getDataPagamento());
		return diferencaDias;
	}
}
