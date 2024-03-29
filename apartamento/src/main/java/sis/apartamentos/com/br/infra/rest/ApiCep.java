package sis.apartamentos.com.br.infra.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import sis.apartamentos.com.br.infra.dto.EnderecoDTO;
import sis.apartamentos.com.br.infra.exception.CepNaoEncontadoException;
import sis.apartamentos.com.br.domain.model.Predio;
import sis.apartamentos.com.br.infra.utils.Constantes;

import java.util.Objects;

@Component
public class ApiCep {

    public Predio request(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        Predio predio = new Predio();
        try {
            EnderecoDTO enderecoTO = restTemplate.getForObject(Constantes.URI_CEP, EnderecoDTO.class, cep);
            if (Objects.nonNull(enderecoTO)) {
                predio.setCep(enderecoTO.getCep());
                predio.setLogradouro(enderecoTO.getLogradouro());
                predio.setComplemento(enderecoTO.getComplemento());
                predio.setBairro(enderecoTO.getBairro());
                predio.setUf(enderecoTO.getUf());
                predio.setLocalidade(enderecoTO.getLocalidade());
                return predio;
            }
        } catch (RestClientException e) {
            throw new CepNaoEncontadoException();
        }
        return predio;
    }
}

