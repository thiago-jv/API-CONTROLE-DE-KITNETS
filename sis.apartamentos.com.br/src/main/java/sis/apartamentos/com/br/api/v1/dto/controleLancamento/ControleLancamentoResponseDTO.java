package sis.apartamentos.com.br.api.v1.dto.controleLancamento;

import lombok.Getter;
import lombok.Setter;
import sis.apartamentos.com.br.api.v1.dto.apartamento.ApartamentoId;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoId;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorId;

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
