package sis.apartamentos.com.br.domain.repository.filter;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import sis.apartamentos.com.br.domain.model.Inquilino;

@Getter
@Setter
public class ControleFilter {

	private String statusApartamePagamento;

	private String statusApartamePagamentoLuz;

	private String entragaContaLuz;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoAte;

	private Inquilino inquilino;

}
