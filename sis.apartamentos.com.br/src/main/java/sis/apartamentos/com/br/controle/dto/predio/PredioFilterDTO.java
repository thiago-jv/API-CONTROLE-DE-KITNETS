package sis.apartamentos.com.br.controle.dto.predio;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PredioFilterDTO {

    @ApiModelProperty(value = "Descrição do predio", example = "predio x")
    private String descricao;
}
