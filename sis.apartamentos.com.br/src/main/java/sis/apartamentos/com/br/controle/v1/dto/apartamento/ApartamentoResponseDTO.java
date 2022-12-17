package sis.apartamentos.com.br.controle.v1.dto.apartamento;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioId;
import sis.apartamentos.com.br.utils.Constantes;

@Getter
@Setter
public class ApartamentoResponseDTO {

    private Long id;

    private String numero;

    private String descricao;

    private String medidor;

    private String statusApartamento = Constantes.DISPONIVEL;

    private PredioId predio;

}
