package sis.apartamentos.com.br.controle.v1.dto.controleLancamento;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoId;
import sis.apartamentos.com.br.controle.v1.dto.inquilino.InquilinoId;
import sis.apartamentos.com.br.controle.v1.dto.valor.ValorId;

import java.time.LocalDate;

@Getter
@Setter
public class ControleLancamentoPostDTO {

    @ApiModelProperty(value = "Data lançamento do controle lançamento", example = "25-02-1989", required = true)
    private LocalDate dataLancamento = LocalDate.now();

    @ApiModelProperty(value = "Data de entrada controle lançamento", example = "25-02-1989", required = true)
    private LocalDate dataEntrada;

    @ApiModelProperty(value = "Data de pagamento controle lançamento", example = "25-02-1989", required = true)
    private LocalDate dataPagamento;

    @ApiModelProperty(value = "Observação controle lançamento", example = "minhas obs...")
    private String observacao;

    @ApiModelProperty(value = "Status do lançamento", example = "..")
    private StatusDTO status;

    @ApiModelProperty(value = "Valores do lançamento", example = "..")
    private ValorRegraDTO valores;

    @ApiModelProperty(value = "ID do valor", example = "1")
    private ValorId valor;

    @ApiModelProperty(value = "ID do inquilino", example = "2")
    private InquilinoId inquilino;

    @ApiModelProperty(value = "ID do apartamento", example = "3")
    private ApartamentoId apartamento;


}
