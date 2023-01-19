package sis.apartamentos.com.br.api.v1.dto.controleLancamento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import sis.apartamentos.com.br.api.v1.dto.apartamento.ApartamentoId;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoId;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorId;

import java.time.LocalDate;

@Getter
@Setter
public class ControleLancamentoPostDTO {

    @ApiModelProperty(value = "Data de entrada controle lançamento", example = "19-01-2023", required = true)
    @JsonFormat(pattern = "dd-MM-yyyy" )
    private LocalDate dataEntrada;

    @ApiModelProperty(value = "Data de pagamento controle lançamento", example = "28-01-2023", required = true)
    @JsonFormat(pattern = "dd-MM-yyyy" )
    private LocalDate dataPagamento;

    @ApiModelProperty(value = "Observação controle lançamento", example = "minhas obs...")
    private String observacao;

    @ApiModelProperty(value = "Status do lançamento", example = "..")
    private StatusDTO status;

    @ApiModelProperty(value = "Valores do lançamento", example = "..")
    private ValorRegraDTO valores;

    @ApiModelProperty(value = "ID do valor", example = "1")
    private ValorId valor;

    @ApiModelProperty(value = "ID do inquilino", example = "2")
    private InquilinoId inquilino;

    @ApiModelProperty(value = "ID do apartamento", example = "3")
    private ApartamentoId apartamento;


}
