package sis.apartamentos.com.br.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;

@Embeddable
public class Valores {

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

	public BigDecimal getValorTotalDiaria() {
		return valorTotalDiaria;
	}

	public void setValorTotalDiaria(BigDecimal valorTotalDiaria) {
		this.valorTotalDiaria = valorTotalDiaria;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public BigDecimal getValorPagoApartamento() {
		return valorPagoApartamento;
	}

	public void setValorPagoApartamento(BigDecimal valorPagoApartamento) {
		this.valorPagoApartamento = valorPagoApartamento;
	}

	public BigDecimal getValorApartamento() {
		return valorApartamento;
	}

	public void setValorApartamento(BigDecimal valorApartamento) {
		this.valorApartamento = valorApartamento;
	}

	public BigDecimal getValorDebitoApartamento() {
		return valorDebitoApartamento;
	}

	public void setValorDebitoApartamento(BigDecimal valorDebitoApartamento) {
		this.valorDebitoApartamento = valorDebitoApartamento;
	}

	public Long getDia() {
		return dia;
	}

	public void setDia(Long dia) {
		this.dia = dia;
	}

}
