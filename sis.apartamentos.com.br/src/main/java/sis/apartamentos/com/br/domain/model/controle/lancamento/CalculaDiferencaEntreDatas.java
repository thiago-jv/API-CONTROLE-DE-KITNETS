package sis.apartamentos.com.br.domain.model.controle.lancamento;

import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.domain.model.ControleLancamento;

@Component
public class CalculaDiferencaEntreDatas {
	
	public Long calculaDia(ControleLancamento controleLancamento) {
		return ChronoUnit.DAYS.between(controleLancamento.getDataEntrada(), controleLancamento.getDataPagamento());
	}
}
