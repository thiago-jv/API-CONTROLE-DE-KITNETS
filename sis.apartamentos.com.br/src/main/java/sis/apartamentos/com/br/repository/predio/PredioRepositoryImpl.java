package sis.apartamentos.com.br.repository.predio;


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

import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.model.Predio_;
import sis.apartamentos.com.br.repository.filter.PredioFilter;

public class PredioRepositoryImpl implements PredioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Predio> filtrar(PredioFilter predioFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Predio> criteria = builder.createQuery(Predio.class);
		Root<Predio> root = criteria.from(Predio.class);
		
		criteria.orderBy(builder.asc(root.get(Predio_.id)));

		Predicate[] predicates = criarRestricoes(predioFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Predio> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(predioFilter));
	}
	
	private Predicate[] criarRestricoes(PredioFilter predioFilter, CriteriaBuilder builder,
			Root<Predio> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(predioFilter.getDescricao())) {
			
			predicates.add(builder.like((root.get("descricao")),
					"%" + predioFilter.getDescricao() + "%"));
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
	
	private Long total(PredioFilter predioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Predio> root = criteria.from(Predio.class);

		Predicate[] predicates = criarRestricoes(predioFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


}
