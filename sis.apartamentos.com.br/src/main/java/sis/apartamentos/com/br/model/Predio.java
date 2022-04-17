package sis.apartamentos.com.br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PREDIO", schema = "public")
public class Predio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "predio_seq")
	@SequenceGenerator(name = "predio_seq", sequenceName = "predio_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	@ApiModelProperty(value = "ID do predio", example = "1", required = true)
	private Long id;

	@NotNull
	@Size(min = 3, max = 90)
	@Column(name = "DESCRICAO", nullable = false, unique = true)
	@ApiModelProperty(value = "Descrição do predio", example = "predio x", required = true)
	private String descricao;

	@Column(name = "CEP", length = 8, nullable = false)
	@ApiModelProperty(value = "Cep do predio", example = "69093118")
	private String cep;

	@Column(name = "LOGRADOURO")
	@ApiModelProperty(value = "Logradouro do predio", example = "Aguas de manaus")
	private String logradouro;

	@Column(name = "COMPLEMENTO")
	@ApiModelProperty(value = "Complemento do predio", example = "proximo de aguas")
	private String complemento;

	@Column(name = "BAIRRO")
	@ApiModelProperty(value = "Bairro do predio", example = "Monte das Oliveiras")
	private String bairro;

	@Column(name = "UF")
	@ApiModelProperty(value = "UF do predio", example = "AM")
	private String uf;

	@Column(name = "LOCALIDADE")
	@ApiModelProperty(value = "Localidade do predio", example = "rua x")
	private String localidade;

	@Column(name = "NUMERO")
	@ApiModelProperty(value = "Número do predio", example = "232")
	private String numero;

	public Predio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
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
		Predio other = (Predio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Predio [id=" + id + ", descricao=" + descricao + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", uf=" + uf + ", localidade=" + localidade
				+ ", numero=" + numero + "]";
	}

}
