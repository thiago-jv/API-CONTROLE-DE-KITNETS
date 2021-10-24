package sis.apartamentos.com.br.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Predio.class)
public abstract class Predio_ {

	public static volatile SingularAttribute<Predio, String> uf;
	public static volatile SingularAttribute<Predio, String> complemento;
	public static volatile SingularAttribute<Predio, String> numero;
	public static volatile SingularAttribute<Predio, String> logradouro;
	public static volatile SingularAttribute<Predio, String> bairro;
	public static volatile SingularAttribute<Predio, String> localidade;
	public static volatile SingularAttribute<Predio, Long> id;
	public static volatile SingularAttribute<Predio, String> descricao;
	public static volatile SingularAttribute<Predio, String> cep;

	public static final String UF = "uf";
	public static final String COMPLEMENTO = "complemento";
	public static final String NUMERO = "numero";
	public static final String LOGRADOURO = "logradouro";
	public static final String BAIRRO = "bairro";
	public static final String LOCALIDADE = "localidade";
	public static final String ID = "id";
	public static final String DESCRICAO = "descricao";
	public static final String CEP = "cep";

}

