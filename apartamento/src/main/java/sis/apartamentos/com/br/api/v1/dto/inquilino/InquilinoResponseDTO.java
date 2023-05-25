package sis.apartamentos.com.br.api.v1.dto.inquilino;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.infra.utils.Constantes;

@Getter
@Setter
public class InquilinoResponseDTO {

    private Long id;

    private String nome;

    private String nomeAbreviado;

    private String email;

    private String contato;

    private String status = Constantes.ATIVO;

    private String genero = Constantes.MASCULINO;

    private String cpf;

}
