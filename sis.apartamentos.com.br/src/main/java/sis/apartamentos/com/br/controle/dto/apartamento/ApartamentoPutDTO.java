package sis.apartamentos.com.br.controle.dto.apartamento;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.controle.dto.predio.PredioId;
import sis.apartamentos.com.br.utils.Constantes;

@Getter
@Setter
public class ApartamentoPutDTO {

    @ApiModelProperty(value = "ID do apartamento", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "Número do apartamento", example = "01", required = true)
    private String numero;

    @ApiModelProperty(value = "Descrição do apartamento", example = "1", required = true)
    private String descricao;

    @ApiModelProperty(value = "Medidor do apartamento", example = "015809")
    private String medidor;

    @ApiModelProperty(value = "Status do apartamento", example = "DISPONIVEL", required = true)
    private String statusApartamento = Constantes.DISPONIVEL;

    @ApiModelProperty(value = "ID do predio", example = "1", required = true)
    private PredioId predio;

}
