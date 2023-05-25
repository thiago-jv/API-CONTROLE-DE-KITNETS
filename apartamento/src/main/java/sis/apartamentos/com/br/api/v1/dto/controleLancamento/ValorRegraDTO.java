package sis.apartamentos.com.br.api.v1.dto.controleLancamento;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorRegraDTO {

	@ApiModelProperty(value = "Status total diária controle lançamento", example = "270", required = true)
	private BigDecimal valorTotalDiaria = BigDecimal.ZERO;

	@ApiModelProperty(value = "Valor diária controle lançamento", example = "8.75", required = true)
	private BigDecimal valorDiaria = BigDecimal.ZERO;

	@ApiModelProperty(value = "Valor pago apartamento controle lançamento", example = "200", required = true)
	private BigDecimal valorPagoApartamento = BigDecimal.ZERO;

	@ApiModelProperty(value = "Valor apartamento controle lançamento", example = "270", required = true)
	private BigDecimal valorApartamento = BigDecimal.ZERO;

	@ApiModelProperty(value = "Valor debito controle lançamento", example = "20")
	private BigDecimal valorDebitoApartamento;

	@ApiModelProperty(value = "Dia controle lançamento", example = "01")
	private Long dia;

}
