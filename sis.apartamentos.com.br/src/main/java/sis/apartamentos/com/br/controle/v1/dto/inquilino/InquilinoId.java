package sis.apartamentos.com.br.controle.v1.dto.inquilino;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquilinoId {

    @ApiModelProperty(value = "ID do Inquilino", example = "1", required = true)
    private Long id;
}
