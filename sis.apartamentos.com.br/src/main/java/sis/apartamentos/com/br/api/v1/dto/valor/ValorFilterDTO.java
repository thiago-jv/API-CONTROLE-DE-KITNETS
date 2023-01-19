package sis.apartamentos.com.br.api.v1.dto.valor;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ValorFilterDTO {

    private BigDecimal valor;
}
