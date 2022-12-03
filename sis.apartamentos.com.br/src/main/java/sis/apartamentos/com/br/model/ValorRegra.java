package sis.apartamentos.com.br.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ValorRegra {

	@Column(name = "VALOR_TOTAL_DIARIA", nullable = false)
	@ApiModelProperty(value = "Status total diária controle lançamento", example = "270", required = true)
	private BigDecimal valorTotalDiaria = BigDecimal.ZERO;

	@Column(name = "VALOR_DIARIA", nullable = false)
	@ApiModelProperty(value = "Valor diária controle lançamento", example = "8.75", required = true)
	private BigDecimal valorDiaria = BigDecimal.ZERO;

	@Column(name = "VALOR_PAGO_APARTAMENTO", nullable = false)
	@ApiModelProperty(value = "Valor pago apartamento controle lançamento", example = "200", required = true)
	private BigDecimal valorPagoApartamento = BigDecimal.ZERO;

	@Column(name = "VALOR_APARTAMENTO", nullable = false)
	@ApiModelProperty(value = "Valor apartamento controle lançamento", example = "270", required = true)
	private BigDecimal valorApartamento = BigDecimal.ZERO;

	@Column(name = "VALOR_DEBITO_APARTAMENTO")
	@ApiModelProperty(value = "Valor debito controle lançamento", example = "20")
	private BigDecimal valorDebitoApartamento;

	@Column(name = "DIA", nullable = false)
	@ApiModelProperty(value = "Dia controle lançamento", example = "01")
	private Long dia;

}
