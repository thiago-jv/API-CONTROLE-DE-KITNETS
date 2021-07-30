package sis.apartamentos.com.br.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import sis.apartamentos.com.br.utils.Constantes;

@Embeddable
public class Status {

	@Column(name = "STATUS_ENTREGA_CONTA_LUZ", length = 20, nullable = false)
	private String entragaContaLuz = Constantes.NAO;

	@Column(name = "STATUS_APARTAMENTO_LUZ", length = 20, nullable = false)
	private String statusApartamePagamentoLuz = Constantes.PAGO;

	@Column(name = "STATUS_APARTAMENTO_PAGAMENTO", length = 20, nullable = false)
	private String statusApartamePagamento = Constantes.PAGO;

	@Column(name = "STATUS_PROXIMO_PAGAMENTO", length = 20, nullable = false)
	private String statusProximoPagamento = Constantes.PAGO;

	@Column(name = "STATUS_CONTROLE", nullable = false)
	private boolean statusControle = true;

	public String getEntragaContaLuz() {
		return entragaContaLuz;
	}

	public void setEntragaContaLuz(String entragaContaLuz) {
		this.entragaContaLuz = entragaContaLuz;
	}

	public String getStatusApartamePagamentoLuz() {
		return statusApartamePagamentoLuz;
	}

	public void setStatusApartamePagamentoLuz(String statusApartamePagamentoLuz) {
		this.statusApartamePagamentoLuz = statusApartamePagamentoLuz;
	}

	public String getStatusApartamePagamento() {
		return statusApartamePagamento;
	}

	public void setStatusApartamePagamento(String statusApartamePagamento) {
		this.statusApartamePagamento = statusApartamePagamento;
	}

	public String getStatusProximoPagamento() {
		return statusProximoPagamento;
	}

	public void setStatusProximoPagamento(String statusProximoPagamento) {
		this.statusProximoPagamento = statusProximoPagamento;
	}

	public boolean isStatusControle() {
		return statusControle;
	}

	public void setStatusControle(boolean statusControle) {
		this.statusControle = statusControle;
	}

}
