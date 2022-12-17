package sis.apartamentos.com.br.controle.v1.dto.controleLancamento;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.utils.Constantes;

import java.io.Serializable;

@Getter
@Setter
public class StatusDTO implements Serializable {

	@ApiModelProperty(value = "Status entrega luz controle lançamento", example = "NAO", required = true)
	private String entragaContaLuz = Constantes.NAO;

	@ApiModelProperty(value = "Status apartamento luz controle lançamento", example = "PAGO", required = true)
	private String statusApartamePagamentoLuz = Constantes.PAGO;

	@ApiModelProperty(value = "Status apartamento pago controle lançamento", example = "PAGO", required = true)
	private String statusApartamePagamento = Constantes.PAGO;

	@ApiModelProperty(value = "Status proximo pagamento controle lançamento", example = "PAGO", required = true)
	private String statusProximoPagamento = Constantes.PAGO;

	@ApiModelProperty(value = "Status controle controle lançamento", example = "true", required = true)
	private boolean statusControle = true;

}
