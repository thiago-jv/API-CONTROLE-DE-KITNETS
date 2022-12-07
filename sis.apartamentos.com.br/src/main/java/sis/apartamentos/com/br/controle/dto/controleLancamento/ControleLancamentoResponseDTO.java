package sis.apartamentos.com.br.controle.dto.controleLancamento;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoId;
import sis.apartamentos.com.br.controle.dto.inquilino.InquilinoId;
import sis.apartamentos.com.br.controle.dto.valor.ValorId;

import java.time.LocalDate;

@Getter
@Setter
public class ControleLancamentoResponseDTO {

    private Long id;

    private LocalDate dataLancamento = LocalDate.now();

    private LocalDate dataEntrada;

    private LocalDate dataPagamento;

    private String observacao;

    private StatusDTO status;

    private ValorRegraDTO valores;

    private ValorId valor;

    private InquilinoId inquilino;

    private ApartamentoId apartamento;

}
