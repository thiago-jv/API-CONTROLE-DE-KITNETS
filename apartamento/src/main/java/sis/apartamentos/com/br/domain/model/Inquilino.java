package sis.apartamentos.com.br.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sis.apartamentos.com.br.infra.utils.Constantes;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
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
	private Long id;

	@Column(name = "NOME", length = 90, nullable = false)
	private String nome;

	@Column(name = "NOMEABREVIADO", length = 20, nullable = false)
	private String nomeAbreviado;

	@Column(name = "EMAIL", length = 90)
	private String email;

	@Column(name = "CONTATO", length = 15)
	private String contato;

	@Column(name = "STATUS", length = 20, nullable = false)
	private String status = Constantes.ATIVO;

	@Column(name = "GENERO", length = 20, nullable = false)
	private String genero = Constantes.MASCULINO;

	@Column(name = "CPF", length = 11, unique = true)
	private String cpf;

	public Inquilino() {

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

}
