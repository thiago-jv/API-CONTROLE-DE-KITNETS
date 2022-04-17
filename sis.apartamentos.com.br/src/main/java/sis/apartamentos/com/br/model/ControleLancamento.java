package sis.apartamentos.com.br.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CONTROLE_LANCAMENTO", schema = "public")
public class ControleLancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controle_lancamento_seq")
	@SequenceGenerator(name = "controle_lancamento_seq", sequenceName = "controle_lancamento_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	@ApiModelProperty(value = "ID do controle lançamento", example = "1", required = true)
	private Long id;

	@Column(name = "DATA_LANCAMENTO", nullable = false)
	@ApiModelProperty(value = "Data lançamento do controle lançamento", example = "25-02-1989", required = true)
	private LocalDate dataLancamento = LocalDate.now();

	@Column(name = "DATA_ENTRADA", nullable = false)
	@ApiModelProperty(value = "Data de entrada controle lançamento", example = "25-02-1989", required = true)
	private LocalDate dataEntrada;

	@Column(name = "DATA_PAGAMENTO", nullable = false)
	@ApiModelProperty(value = "Data de pagamento controle lançamento", example = "25-02-1989", required = true)
	private LocalDate dataPagamento;

	@Column(name = "OBSERVACAO")
	@ApiModelProperty(value = "Observação controle lançamento", example = "minhas obs...")
	private String observacao;

	@Embedded
	private Status status;

	@Embedded
	private Valores valores;

	@ManyToOne
	@JoinColumn(name = "ID_VALOR", referencedColumnName = "ID", nullable = false)
	@ApiModelProperty(value = "ID do valor", example = "1")
	private Valor valor;

	@ManyToOne
	@JoinColumn(name = "ID_INQUILINO", referencedColumnName = "ID", nullable = false)
	@ApiModelProperty(value = "ID do inquilino", example = "2")
	private Inquilino inquilino;

	@ManyToOne
	@JoinColumn(name = "ID_APARTAMENTO", referencedColumnName = "ID", nullable = false)
	@ApiModelProperty(value = "ID do apartamento", example = "3")
	private Apartamento apartamento;

	public ControleLancamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Valores getValores() {
		return valores;
	}

	public void setValores(Valores valores) {
		this.valores = valores;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleLancamento other = (ControleLancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ControleLancamento [id=" + id + ", dataLancamento=" + dataLancamento + ", dataEntrada=" + dataEntrada
				+ ", dataPagamento=" + dataPagamento + ", observacao=" + observacao + ", status=" + status
				+ ", valores=" + valores + ", valor=" + valor + ", inquilino=" + inquilino + ", apartamento="
				+ apartamento + "]";
	}

}
