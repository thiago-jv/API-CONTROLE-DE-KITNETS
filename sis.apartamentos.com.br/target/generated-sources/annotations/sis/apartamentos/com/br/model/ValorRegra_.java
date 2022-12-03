package sis.apartamentos.com.br.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ValorRegra.class)
public abstract class ValorRegra_ {

	public static volatile SingularAttribute<ValorRegra, BigDecimal> valorPagoApartamento;
	public static volatile SingularAttribute<ValorRegra, BigDecimal> valorDebitoApartamento;
	public static volatile SingularAttribute<ValorRegra, BigDecimal> valorDiaria;
	public static volatile SingularAttribute<ValorRegra, BigDecimal> valorApartamento;
	public static volatile SingularAttribute<ValorRegra, BigDecimal> valorTotalDiaria;
	public static volatile SingularAttribute<ValorRegra, Long> dia;

	public static final String VALOR_PAGO_APARTAMENTO = "valorPagoApartamento";
	public static final String VALOR_DEBITO_APARTAMENTO = "valorDebitoApartamento";
	public static final String VALOR_DIARIA = "valorDiaria";
	public static final String VALOR_APARTAMENTO = "valorApartamento";
	public static final String VALOR_TOTAL_DIARIA = "valorTotalDiaria";
	public static final String DIA = "dia";

}

