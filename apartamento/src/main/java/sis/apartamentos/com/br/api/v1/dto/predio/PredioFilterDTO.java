package sis.apartamentos.com.br.api.v1.dto.predio;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredioFilterDTO {

    @ApiModelProperty(value = "Descrição do predio", example = "predio x")
    private String descricao;
}
