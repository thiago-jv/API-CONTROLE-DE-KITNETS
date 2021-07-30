package sis.apartamentos.com.br.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import sis.apartamentos.com.br.dto.EnderecoDTO;
import sis.apartamentos.com.br.exception.CepNaoEncontadoException;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.utils.Constantes;

@Component
public class ApiCep {
	
	public Predio request(String cep){
		RestTemplate restTemplate = new RestTemplate(); 
		
		try{
			EnderecoDTO enderecoTO = restTemplate.getForObject(Constantes.URI_CEP, EnderecoDTO.class, cep);
			
			Predio predio = new Predio();
			
			predio.setCep(enderecoTO.getCep());
			predio.setLogradouro(enderecoTO.getLogradouro());
			predio.setComplemento(enderecoTO.getComplemento());
			predio.setBairro(enderecoTO.getBairro());
			predio.setUf(enderecoTO.getUf());
			predio.setLocalidade(enderecoTO.getLocalidade());
			
			return predio;
		}
		catch(RestClientException e){
			throw new CepNaoEncontadoException();
		}
	}
}
