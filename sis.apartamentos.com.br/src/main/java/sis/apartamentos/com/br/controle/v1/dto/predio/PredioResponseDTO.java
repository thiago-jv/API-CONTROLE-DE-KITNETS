package sis.apartamentos.com.br.controle.v1.dto.predio;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredioResponseDTO {

    private Long id;

    private String descricao;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String uf;

    private String localidade;

    private String numero;
}
