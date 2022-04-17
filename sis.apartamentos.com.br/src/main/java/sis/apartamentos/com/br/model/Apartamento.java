package sis.apartamentos.com.br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import sis.apartamentos.com.br.utils.Constantes;

@Entity
@Table(name = "APARTAMENTO", schema = "public")
public class Apartamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartamento_seq")
	@SequenceGenerator(name = "apartamento_seq", sequenceName = "apartamento_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	@ApiModelProperty(value = "ID do apartamento", example = "1", required = true)
	private Long id;

	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "NUMERO", nullable = false, unique = true)
	@ApiModelProperty(value = "Número do apartamento", example = "01", required = true)
	private String numero;

	@NotNull
	@Size(min = 1, max = 90)
	@Column(name = "DESCRICAO", nullable = false, unique = true)
	@ApiModelProperty(value = "Descrição do apartamento", example = "1", required = true)
	private String descricao;

	@Size(min = 1, max = 10)
	@Column(name = "MEDIDOR", unique = true)
	@ApiModelProperty(value = "Medidor do apartamento", example = "015809")
	private String medidor;

	@Column(name = "STATUS_APARTAMENTO", length = 20, nullable = false)
	@ApiModelProperty(value = "Status do apartamento", example = "DISPONIVEL", required = true)
	private String statusApartamento = Constantes.DISPONIVEL;

	@ManyToOne
	@JoinColumn(name = "ID_PREDIO", referencedColumnName = "ID", nullable = false)
	@ApiModelProperty(value = "ID do predio", example = "1", required = true)
	private Predio predio;

	public Apartamento() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatusApartamento() {
		return statusApartamento;
	}

	public void setStatusApartamento(String statusApartamento) {
		this.statusApartamento = statusApartamento;
	}

	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public String getMedidor() {
		return medidor;
	}

	public void setMedidor(String medidor) {
		this.medidor = medidor;
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
		Apartamento other = (Apartamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Apartamento [id=" + id + ", numero=" + numero + ", descricao=" + descricao + ", statusApartamento="
				+ statusApartamento + ", predio=" + predio + "]";
	}

}
