package sis.apartamentos.com.br.controle.dto.valor;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorResponseDTO {

    @ApiModelProperty(value = "ID do valor", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "Valor", example = "250.0", required = true)
    private BigDecimal valor = BigDecimal.ZERO;
}
