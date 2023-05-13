package sis.apartamentos.com.br.infra.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class LancamentoApartamentoDTO {

    private Long idLancamento;
    private String dataEntrada;
    private String nomeInquilino;
    private String valor;
    private String predio;
    private String numeroQuarto;
    private String cep;
    private String bairro;
    private String uf;

    private String localidade;
    private String logradouro;

}
