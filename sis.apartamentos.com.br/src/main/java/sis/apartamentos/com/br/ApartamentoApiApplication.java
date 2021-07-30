package sis.apartamentos.com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import sis.apartamentos.com.br.config.property.ApartamentoApiProperty;


@SpringBootApplication
@EnableConfigurationProperties(ApartamentoApiProperty.class)
public class ApartamentoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartamentoApiApplication.class, args);
	}
	
}
