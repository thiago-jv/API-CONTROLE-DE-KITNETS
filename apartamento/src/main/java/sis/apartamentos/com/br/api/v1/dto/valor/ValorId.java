package sis.apartamentos.com.br.api.v1.dto.valor;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValorId {

    @ApiModelProperty(value = "ID do valor", example = "1", required = true)
    private Long id;
}
