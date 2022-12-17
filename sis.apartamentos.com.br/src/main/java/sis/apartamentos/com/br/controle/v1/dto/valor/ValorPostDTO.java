package sis.apartamentos.com.br.controle.v1.dto.valor;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorPostDTO {

    @ApiModelProperty(value = "Valor", example = "250.0", required = true)
    private BigDecimal valor = BigDecimal.ZERO;
}
