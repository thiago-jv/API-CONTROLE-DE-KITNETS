package sis.apartamentos.com.br.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.utils.Constantes;

@Getter
@Setter
@Embeddable
public class Status {

	@Column(name = "STATUS_ENTREGA_CONTA_LUZ", length = 20, nullable = false)
	@ApiModelProperty(value = "Status entrega luz controle lançamento", example = "NAO", required = true)
	private String entragaContaLuz = Constantes.NAO;

	@Column(name = "STATUS_APARTAMENTO_LUZ", length = 20, nullable = false)
	@ApiModelProperty(value = "Status apartamento luz controle lançamento", example = "PAGO", required = true)
	private String statusApartamePagamentoLuz = Constantes.PAGO;

	@Column(name = "STATUS_APARTAMENTO_PAGAMENTO", length = 20, nullable = false)
	@ApiModelProperty(value = "Status apartamento pago controle lançamento", example = "PAGO", required = true)
	private String statusApartamePagamento = Constantes.PAGO;

	@Column(name = "STATUS_PROXIMO_PAGAMENTO", length = 20, nullable = false)
	@ApiModelProperty(value = "Status proximo pagamento controle lançamento", example = "PAGO", required = true)
	private String statusProximoPagamento = Constantes.PAGO;

	@Column(name = "STATUS_CONTROLE", nullable = false)
	@ApiModelProperty(value = "Status controle controle lançamento", example = "true", required = true)
	private boolean statusControle = true;

}
