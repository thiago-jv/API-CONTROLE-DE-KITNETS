package sis.apartamentos.com.br.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Apartamento.class)
public abstract class Apartamento_ {

	public static volatile SingularAttribute<Apartamento, Predio> predio;
	public static volatile SingularAttribute<Apartamento, String> numero;
	public static volatile SingularAttribute<Apartamento, String> medidor;
	public static volatile SingularAttribute<Apartamento, String> statusApartamento;
	public static volatile SingularAttribute<Apartamento, Long> id;
	public static volatile SingularAttribute<Apartamento, String> descricao;

	public static final String PREDIO = "predio";
	public static final String NUMERO = "numero";
	public static final String MEDIDOR = "medidor";
	public static final String STATUS_APARTAMENTO = "statusApartamento";
	public static final String ID = "id";
	public static final String DESCRICAO = "descricao";

}

