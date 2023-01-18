package sis.apartamentos.com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import sis.apartamentos.com.br.config.ApartamentoApiProperty;


@SpringBootApplication
@EnableConfigurationProperties(ApartamentoApiProperty.class)
public class ApartamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartamentoApiApplication.class, args);
	}
	
}
