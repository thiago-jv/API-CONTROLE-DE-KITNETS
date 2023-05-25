package sis.apartamentos.com.br.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
@Table(name = "DIARIO", schema = "public")
public class Diario implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diario_seq")
    @SequenceGenerator(name = "diario_seq", sequenceName = "diario_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public Diario() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diario diario = (Diario) o;
        return Objects.equals(id, diario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
