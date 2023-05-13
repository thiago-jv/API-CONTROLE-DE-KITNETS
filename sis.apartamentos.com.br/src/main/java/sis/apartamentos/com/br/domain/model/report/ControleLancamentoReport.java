package sis.apartamentos.com.br.domain.model.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@ToString
@Table(name = "CONTROLE_LANCAMENTO_REPORT", schema = "public")
public class ControleLancamentoReport implements Serializable {


    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Long idLancamento;

    @Column(name = "DATAENTRADA", nullable = false)
    private String dataEntrada;

    @Column(name = "NOMEINQUILINO", nullable = false)
    private String nomeInquilino;

    @Column(name = "VALOR", nullable = false)
    private String valor;

    @Column(name = "PREDIO", nullable = false)
    private String predio;

    @Column(name = "NUMEROQUARTO", nullable = false)
    private String numeroQuarto;

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "UF", nullable = false)
    private String uf;

    @Column(name = "LOCALIDADE", nullable = false)
    private String localidade;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    public ControleLancamentoReport() {

    }
}
