package sis.apartamentos.com.br.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import sis.apartamentos.com.br.utils.Constantes;

@Entity
@Table(name = "INQUILINO", schema = "public")
public class Inquilino implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inquilino_seq")
	@SequenceGenerator(name = "inquilino_seq", sequenceName = "inquilino_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "ID", nullable = false, unique = true)
	@ApiModelProperty(value = "ID do inquilino", example = "1", required = true)
	private Long id;

	@Column(name = "NOME", length = 90, nullable = false)
	@ApiModelProperty(value = "Nome do inquilino", example = "Thiago", required = true)
	private String nome;

	@Column(name = "NOME_ABREVIADO", length = 20, nullable = false)
	@ApiModelProperty(value = "Nome Abreviado do inquilino", example = "T. Henrique", required = true)
	private String nomeAbreviado;

	@Column(name = "EMAIL", length = 90)
	@ApiModelProperty(value = "Email do inquilino", example = "thiago.henrique.25@hotmail.com")
	private String email;

	@Column(name = "CONTATO", length = 15)
	@ApiModelProperty(value = "Contato do inquilino", example = "92991679486")
	private String contato;

	@Column(name = "STATUS", length = 20, nullable = false)
	@ApiModelProperty(value = "Status do inquilino", example = "ATIVO", required = true)
	private String status = Constantes.ATIVO;

	@Column(name = "GENERO", length = 20, nullable = false)
	@ApiModelProperty(value = "Genero do inquilino", example = "MASCULINO", required = true)
	private String genero = Constantes.MASCULINO;

	@Column(name = "cpf", length = 11, unique = true)
	@ApiModelProperty(value = "Cpf do inquilino", example = "88371468252")
	private String cpf;

	public Inquilino() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeAbreviado() {
		return nomeAbreviado;
	}

	public void setNomeAbreviado(String nomeAbreviado) {
		this.nomeAbreviado = nomeAbreviado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		Inquilino other = (Inquilino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", nome=" + nome + ", email=" + email + ", contato=" + contato + ", genero="
				+ genero + ", cpf=" + cpf + "]";
	}

}
