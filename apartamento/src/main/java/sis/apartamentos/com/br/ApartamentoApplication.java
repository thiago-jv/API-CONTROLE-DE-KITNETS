package sis.apartamentos.com.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import sis.apartamentos.com.br.infra.config.ApartamentoApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ApartamentoApiProperty.class)
public class ApartamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApartamentoApplication.class, args);
	}

}
