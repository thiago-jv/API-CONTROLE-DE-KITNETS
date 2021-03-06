package sis.apartamentos.com.br.model.controle.lancamento;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Component;

import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.utils.Constantes;

@Component
public class CalcularValorPago {

	public ControleLancamento calcularValorPagoApartamento(ControleLancamento controleLancamento) {
		if (validaValorPagoApartamento(controleLancamento)) {
			controleLancamento.getValores()
					.setValorDebitoApartamento(controleLancamento.getValores().getValorTotalDiaria().subtract(
							controleLancamento.getValores().getValorPagoApartamento(), MathContext.DECIMAL128));
			modificaStatusApartamento(controleLancamento);
		}
		return controleLancamento;
	}
	
	public Boolean validaValorPagoApartamento(ControleLancamento controleLancamento) {
		return controleLancamento.getValores().getValorTotalDiaria() != null
				&& controleLancamento.getValores().getValorPagoApartamento() != null;
	}
	
	private ControleLancamento modificaStatusApartamento(ControleLancamento controleLancamento) {
		if (validaStatusApartamento(controleLancamento)) {
			controleLancamento.getStatus().setStatusApartamePagamento(Constantes.PAGO);
		} else {
			controleLancamento.getStatus().setStatusApartamePagamento(Constantes.DEBITO);
		}
		return controleLancamento;
	}
	
	public Boolean validaStatusApartamento(ControleLancamento controleLancamento) {
		return controleLancamento.getValores().getValorDebitoApartamento().compareTo(BigDecimal.ZERO) <= 0;
	}
	
}
