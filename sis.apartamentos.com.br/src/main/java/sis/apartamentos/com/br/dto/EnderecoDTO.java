package sis.apartamentos.com.br.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EnderecoDTO {
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;

	private String uf;
	
	private String localidade;
	
}
