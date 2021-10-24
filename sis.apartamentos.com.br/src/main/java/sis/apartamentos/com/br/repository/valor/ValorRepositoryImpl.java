package sis.apartamentos.com.br.repository.valor;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.model.Valor_;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

public class ValorRepositoryImpl implements ValorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Valor> filtrar(ValorFilter valorFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Valor> criteria = builder.createQuery(Valor.class);
		Root<Valor> root = criteria.from(Valor.class);
		
		criteria.orderBy(builder.asc(root.get(Valor_.id)));

		Predicate[] predicates = criarRestricoes(valorFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Valor> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(valorFilter));
	}
	
	private Predicate[] criarRestricoes(ValorFilter valorFilter, CriteriaBuilder builder,
			Root<Valor> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(valorFilter.getValor())) {
			predicates.add(builder.equal((root.get("valor")), valorFilter.getValor()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	private Long total(ValorFilter valorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Valor> root = criteria.from(Valor.class);

		Predicate[] predicates = criarRestricoes(valorFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


}
