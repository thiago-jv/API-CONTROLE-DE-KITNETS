package sis.apartamentos.com.br.core;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.classmate.TypeResolver;

import sis.apartamentos.com.br.exception.handler.Problema;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.openapi.model.ApartamentoModelOpenApi;
import sis.apartamentos.com.br.openapi.model.PageableOpenApi;
import sis.apartamentos.com.br.openapi.model.PredioModelOpenApi;
import sis.apartamentos.com.br.openapi.model.ValorModelOpenApi;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket apiDocket() {
		TypeResolver typeResolver = new TypeResolver();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				 .apis(RequestHandlerSelectors.basePackage("sis.apartamentos.com.br"))
	                .paths(PathSelectors.any())
	                .build()
	                .useDefaultResponseMessages(false)
		            .globalResponseMessage(RequestMethod.GET, globalGetResponseMessages())
		            .globalResponseMessage(RequestMethod.POST, globalPostPutResponseMessages())
		            .globalResponseMessage(RequestMethod.PUT, globalPostPutResponseMessages())
		            .globalResponseMessage(RequestMethod.DELETE, globalDeleteResponseMessages())
		            .additionalModels(typeResolver.resolve(Problema.class))
		            .directModelSubstitute(Pageable.class, PageableOpenApi.class)
		            
		            .alternateTypeRules(AlternateTypeRules.newRule(
		                    typeResolver.resolve(Page.class, Valor.class),
		                    ValorModelOpenApi.class))
		            
		            .alternateTypeRules(AlternateTypeRules.newRule(
		                    typeResolver.resolve(Page.class, Apartamento.class),
		                    ApartamentoModelOpenApi.class))
		            
		            .alternateTypeRules(AlternateTypeRules.newRule(
		                    typeResolver.resolve(Page.class, Predio.class),
		                    PredioModelOpenApi.class))
		            
		            .apiInfo(apiInfo());
	}
	
	private List<ResponseMessage> globalGetResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno do servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build()
			);
	}
	
	private List<ResponseMessage> globalPostPutResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.NOT_ACCEPTABLE.value())
					.message("Recurso não possui representação que poderia ser aceita pelo consumidor")
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
					.message("Requisição recusada porque o corpo está em um formato não suportado")
					.responseModel(new ModelRef("Problema"))
					.build()
			);
	}
	
	private List<ResponseMessage> globalDeleteResponseMessages() {
		return Arrays.asList(
				new ResponseMessageBuilder()
					.code(HttpStatus.BAD_REQUEST.value())
					.message("Requisição inválida (erro do cliente)")
					.responseModel(new ModelRef("Problema"))
					.build(),
				new ResponseMessageBuilder()
					.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
					.message("Erro interno no servidor")
					.responseModel(new ModelRef("Problema"))
					.build()
			);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SIS APARTAMENTOS - API")
				.description("Api para controle de apartamentos")
				.version("1")
				.contact(new Contact("Thiago Henrique", "https://github.com/thiago-jv/", "thiago.henrique.25@hotmail.com"))
				.build();
	}
	
}
