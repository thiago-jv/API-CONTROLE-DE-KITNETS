package sis.apartamentos.com.br.api.v1.dto.apartamento;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartamentoId {

    @ApiModelProperty(value = "ID do Apartamento", example = "1", required = true)
    private Long id;
}
