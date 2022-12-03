package sis.apartamentos.com.br.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;

	private String uf;
	
	private String localidade;
	
}
