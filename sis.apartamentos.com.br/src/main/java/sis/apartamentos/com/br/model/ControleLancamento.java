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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
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
	private Long id;

	@Column(name = "DATA_LANCAMENTO", nullable = false)
	private LocalDate dataLancamento = LocalDate.now();

	@Column(name = "DATA_ENTRADA", nullable = false)
	private LocalDate dataEntrada;

	@Column(name = "DATA_PAGAMENTO", nullable = false)
	private LocalDate dataPagamento;

	@Column(name = "OBSERVACAO")
	private String observacao;

	@Embedded
	private Status status;

	@Embedded
	private ValorRegra valores;

	@ManyToOne
	@JoinColumn(name = "ID_VALOR", referencedColumnName = "ID", nullable = false)
	private Valor valor;

	@ManyToOne
	@JoinColumn(name = "ID_INQUILINO", referencedColumnName = "ID", nullable = false)
	private Inquilino inquilino;

	@ManyToOne
	@JoinColumn(name = "ID_APARTAMENTO", referencedColumnName = "ID", nullable = false)
	private Apartamento apartamento;

	public ControleLancamento() {

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

}
