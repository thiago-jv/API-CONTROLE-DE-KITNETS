package sis.apartamentos.com.br.controle.v1.dto.inquilino;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InquilinoFilterDTO {

    private String nome;

    private String cpf;

    private String status;
}
