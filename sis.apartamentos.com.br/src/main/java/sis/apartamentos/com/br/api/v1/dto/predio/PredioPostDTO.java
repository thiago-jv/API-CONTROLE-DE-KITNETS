package sis.apartamentos.com.br.api.v1.dto.predio;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredioPostDTO {

    @ApiModelProperty(value = "Descrição do predio", example = "predio x", required = true)
    private String descricao;

    @ApiModelProperty(value = "Cep do predio", example = "69093118")
    private String cep;

    @ApiModelProperty(value = "Logradouro do predio", example = "Aguas de manaus")
    private String logradouro;

    @ApiModelProperty(value = "Complemento do predio", example = "proximo de aguas")
    private String complemento;

    @ApiModelProperty(value = "Bairro do predio", example = "Monte das Oliveiras")
    private String bairro;

    @ApiModelProperty(value = "UF do predio", example = "AM")
    private String uf;

    @ApiModelProperty(value = "Localidade do predio", example = "rua x")
    private String localidade;

    @ApiModelProperty(value = "Número do predio", example = "232")
    private String numero;

}
