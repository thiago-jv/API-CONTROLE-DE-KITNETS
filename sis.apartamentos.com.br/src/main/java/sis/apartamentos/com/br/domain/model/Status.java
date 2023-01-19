package sis.apartamentos.com.br.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.infra.utils.Constantes;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class Status implements Serializable {

	@Column(name = "STATUSENTREGACONTALUZ", length = 20, nullable = false)
	private String entragaContaLuz = Constantes.NAO;

	@Column(name = "STATUSAPARTAMENTOLUZ", length = 20, nullable = false)
	private String statusApartamePagamentoLuz = Constantes.PAGO;

	@Column(name = "STATUSAPARTAMENTOPAGAMENTO", length = 20, nullable = false)
	private String statusApartamePagamento = Constantes.PAGO;

	@Column(name = "STATUSPROXIMOPAGAMENTO", length = 20, nullable = false)
	private String statusProximoPagamento = Constantes.PAGO;

	@Column(name = "STATUSCONTROLE", nullable = false)
	private boolean statusControle = true;

}
