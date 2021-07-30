package sis.apartamentos.com.br.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import sis.apartamentos.com.br.model.Inquilino;

public class ControleFilter {

	private String statusApartamePagamento;

	private String statusApartamePagamentoLuz;

	private String entragaContaLuz;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoDe;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamentoAte;

	private Inquilino inquilino;

	public String getStatusApartamePagamento() {
		return statusApartamePagamento;
	}

	public void setStatusApartamePagamento(String statusApartamePagamento) {
		this.statusApartamePagamento = statusApartamePagamento;
	}

	public String getStatusApartamePagamentoLuz() {
		return statusApartamePagamentoLuz;
	}

	public void setStatusApartamePagamentoLuz(String statusApartamePagamentoLuz) {
		this.statusApartamePagamentoLuz = statusApartamePagamentoLuz;
	}

	public String getEntragaContaLuz() {
		return entragaContaLuz;
	}

	public void setEntragaContaLuz(String entragaContaLuz) {
		this.entragaContaLuz = entragaContaLuz;
	}

	public LocalDate getDataPagamentoDe() {
		return dataPagamentoDe;
	}

	public void setDataPagamentoDe(LocalDate dataPagamentoDe) {
		this.dataPagamentoDe = dataPagamentoDe;
	}

	public LocalDate getDataPagamentoAte() {
		return dataPagamentoAte;
	}

	public void setDataPagamentoAte(LocalDate dataPagamentoAte) {
		this.dataPagamentoAte = dataPagamentoAte;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}


}