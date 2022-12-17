package sis.apartamentos.com.br.controle.v1.dto.inquilino;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.utils.Constantes;

@Getter
@Setter
public class InquilinoPutDTO {

    @ApiModelProperty(value = "ID do inquilino", example = "1", required = true)
    private Long id;

    @ApiModelProperty(value = "Nome do inquilino", example = "Thiago", required = true)
    private String nome;

    @ApiModelProperty(value = "Nome Abreviado do inquilino", example = "T. Henrique", required = true)
    private String nomeAbreviado;

    @ApiModelProperty(value = "Email do inquilino", example = "thiago.henrique.25@hotmail.com")
    private String email;

    @ApiModelProperty(value = "Contato do inquilino", example = "92991679486")
    private String contato;

    @ApiModelProperty(value = "Status do inquilino", example = "ATIVO", required = true)
    private String status = Constantes.ATIVO;

    @ApiModelProperty(value = "Genero do inquilino", example = "MASCULINO", required = true)
    private String genero = Constantes.MASCULINO;

    @ApiModelProperty(value = "Cpf do inquilino", example = "88371468252")
    private String cpf;

}
