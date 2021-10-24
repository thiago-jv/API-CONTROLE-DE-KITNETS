package sis.apartamentos.com.br.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Status.class)
public abstract class Status_ {

	public static volatile SingularAttribute<Status, String> statusApartamePagamento;
	public static volatile SingularAttribute<Status, Boolean> statusControle;
	public static volatile SingularAttribute<Status, String> entragaContaLuz;
	public static volatile SingularAttribute<Status, String> statusApartamePagamentoLuz;
	public static volatile SingularAttribute<Status, String> statusProximoPagamento;

	public static final String STATUS_APARTAME_PAGAMENTO = "statusApartamePagamento";
	public static final String STATUS_CONTROLE = "statusControle";
	public static final String ENTRAGA_CONTA_LUZ = "entragaContaLuz";
	public static final String STATUS_APARTAME_PAGAMENTO_LUZ = "statusApartamePagamentoLuz";
	public static final String STATUS_PROXIMO_PAGAMENTO = "statusProximoPagamento";

}

