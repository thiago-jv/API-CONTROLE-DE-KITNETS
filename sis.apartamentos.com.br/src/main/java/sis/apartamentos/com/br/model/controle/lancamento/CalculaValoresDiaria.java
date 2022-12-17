package sis.apartamentos.com.br.model.controle.lancamento;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.model.ControleLancamento;

@Component
public class CalculaValoresDiaria {

	public ControleLancamento valculaDiaria(ControleLancamento controleLancamento) {
		BigDecimal dias = new BigDecimal(controleLancamento.getValores().getDia());
		
		BigDecimal valorDiaria = controleLancamento.getValores().getValorApartamento().divide(dias,
				MathContext.DECIMAL128);

		controleLancamento.getValores().setValorDiaria(valorDiaria);
		
		controleLancamento.getValores().setValorTotalDiaria(dias.multiply(controleLancamento.getValores().getValorDiaria()));

		return controleLancamento;
	}
}