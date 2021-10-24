package sis.apartamentos.com.br.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inquilino.class)
public abstract class Inquilino_ {

	public static volatile SingularAttribute<Inquilino, String> genero;
	public static volatile SingularAttribute<Inquilino, String> cpf;
	public static volatile SingularAttribute<Inquilino, String> nome;
	public static volatile SingularAttribute<Inquilino, Long> id;
	public static volatile SingularAttribute<Inquilino, String> nomeAbreviado;
	public static volatile SingularAttribute<Inquilino, String> contato;
	public static volatile SingularAttribute<Inquilino, String> email;
	public static volatile SingularAttribute<Inquilino, String> status;

	public static final String GENERO = "genero";
	public static final String CPF = "cpf";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String NOME_ABREVIADO = "nomeAbreviado";
	public static final String CONTATO = "contato";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}

