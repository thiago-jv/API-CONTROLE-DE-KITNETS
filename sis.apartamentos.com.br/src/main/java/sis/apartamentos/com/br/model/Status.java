package sis.apartamentos.com.br.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.utils.Constantes;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Status implements Serializable {

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

}
