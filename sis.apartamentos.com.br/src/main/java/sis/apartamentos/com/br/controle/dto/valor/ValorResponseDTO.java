package sis.apartamentos.com.br.controle.dto.valor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValorResponseDTO {

    private Long id;

    private BigDecimal valor = BigDecimal.ZERO;
}
