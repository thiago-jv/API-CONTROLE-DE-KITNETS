package sis.apartamentos.com.br.controle.v1.dto.controleLancamento;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sis.apartamentos.com.br.controle.v1.dto.inquilino.InquilinoId;

import java.time.LocalDate;

@Getter
@Setter
public class ControleLancamentoFilterDTO {

    private String statusApartamePagamento;

    private String statusApartamePagamentoLuz;

    private String entragaContaLuz;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamentoDe;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamentoAte;

    private InquilinoId inquilino;

}
