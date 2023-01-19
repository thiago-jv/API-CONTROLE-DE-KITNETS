package sis.apartamentos.com.br.infra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LancamentoApartamentoDTO {

    private Long idLancamento;
    private String dataEntrada;
    private String nome;
    private String predio;
    private String numeroQuarto;

}
