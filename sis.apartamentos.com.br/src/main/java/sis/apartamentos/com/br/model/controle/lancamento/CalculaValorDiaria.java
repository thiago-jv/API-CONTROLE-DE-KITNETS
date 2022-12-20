package sis.apartamentos.com.br.model.controle.lancamento;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.model.ControleLancamento;

@Component
public class CalculaValorDiaria {

	public ControleLancamento calculaDiaria(ControleLancamento controleLancamento) {
		BigDecimal dias = new BigDecimal(controleLancamento.getValores().getDia());
		int diasDoMes = controleLancamento.getDataEntrada().lengthOfMonth();
		BigDecimal valorDiaria = controleLancamento.getValores().getValorApartamento().divide(BigDecimal.valueOf(diasDoMes),
				MathContext.DECIMAL128);

		controleLancamento.getValores().setValorDiaria(valorDiaria);
		
		controleLancamento.getValores().setValorTotalDiaria(dias.multiply(controleLancamento.getValores().getValorDiaria()));

		return controleLancamento;
	}
}
