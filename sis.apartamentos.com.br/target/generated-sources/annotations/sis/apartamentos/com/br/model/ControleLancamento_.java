package sis.apartamentos.com.br.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ControleLancamento.class)
public abstract class ControleLancamento_ {

	public static volatile SingularAttribute<ControleLancamento, Apartamento> apartamento;
	public static volatile SingularAttribute<ControleLancamento, String> observacao;
	public static volatile SingularAttribute<ControleLancamento, LocalDate> dataPagamento;
	public static volatile SingularAttribute<ControleLancamento, LocalDate> dataEntrada;
	public static volatile SingularAttribute<ControleLancamento, Valor> valor;
	public static volatile SingularAttribute<ControleLancamento, ValorRegra> valores;
	public static volatile SingularAttribute<ControleLancamento, Inquilino> inquilino;
	public static volatile SingularAttribute<ControleLancamento, Long> id;
	public static volatile SingularAttribute<ControleLancamento, LocalDate> dataLancamento;
	public static volatile SingularAttribute<ControleLancamento, Status> status;

	public static final String APARTAMENTO = "apartamento";
	public static final String OBSERVACAO = "observacao";
	public static final String DATA_PAGAMENTO = "dataPagamento";
	public static final String DATA_ENTRADA = "dataEntrada";
	public static final String VALOR = "valor";
	public static final String VALORES = "valores";
	public static final String INQUILINO = "inquilino";
	public static final String ID = "id";
	public static final String DATA_LANCAMENTO = "dataLancamento";
	public static final String STATUS = "status";

}

