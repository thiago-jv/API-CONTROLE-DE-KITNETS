package sis.apartamentos.com.br.controle.dto.predio;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredioId {

    @ApiModelProperty(value = "ID do predio", example = "1", required = true)
    private Long id;
}
