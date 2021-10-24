package sis.apartamentos.com.br.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Valores.class)
public abstract class Valores_ {

	public static volatile SingularAttribute<Valores, BigDecimal> valorPagoApartamento;
	public static volatile SingularAttribute<Valores, BigDecimal> valorDebitoApartamento;
	public static volatile SingularAttribute<Valores, BigDecimal> valorDiaria;
	public static volatile SingularAttribute<Valores, BigDecimal> valorApartamento;
	public static volatile SingularAttribute<Valores, BigDecimal> valorTotalDiaria;
	public static volatile SingularAttribute<Valores, Long> dia;

	public static final String VALOR_PAGO_APARTAMENTO = "valorPagoApartamento";
	public static final String VALOR_DEBITO_APARTAMENTO = "valorDebitoApartamento";
	public static final String VALOR_DIARIA = "valorDiaria";
	public static final String VALOR_APARTAMENTO = "valorApartamento";
	public static final String VALOR_TOTAL_DIARIA = "valorTotalDiaria";
	public static final String DIA = "dia";

}

