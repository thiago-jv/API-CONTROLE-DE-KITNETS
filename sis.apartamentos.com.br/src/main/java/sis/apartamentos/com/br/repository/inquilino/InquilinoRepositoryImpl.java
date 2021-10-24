package sis.apartamentos.com.br.repository.inquilino;

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

import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.model.Inquilino_;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;

public class InquilinoRepositoryImpl implements InquilinoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Inquilino> filtrar(InquilinoFilter inquilinoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Inquilino> criteria = builder.createQuery(Inquilino.class);
		Root<Inquilino> root = criteria.from(Inquilino.class);
		
		criteria.orderBy(builder.asc(root.get(Inquilino_.id)));

		Predicate[] predicates = criarRestricoes(inquilinoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Inquilino> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(inquilinoFilter));
	}
	
	private Predicate[] criarRestricoes(InquilinoFilter inquilinoFilter, CriteriaBuilder builder,
			Root<Inquilino> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(inquilinoFilter.getNome())) {
			
			predicates.add(builder.like((root.get("nome")),
					"%" + inquilinoFilter.getNome() + "%"));
		}
		
        if (!StringUtils.isEmpty(inquilinoFilter.getCpf())) {
			
			predicates.add(builder.like((root.get("cpf")),
					"%" + inquilinoFilter.getCpf() + "%"));
		}
        
        if (!StringUtils.isEmpty(inquilinoFilter.getStatus())) {

			predicates.add(builder.equal((root.get("status")), inquilinoFilter.getStatus()));
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
	
	private Long total(InquilinoFilter inquilinoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Inquilino> root = criteria.from(Inquilino.class);

		Predicate[] predicates = criarRestricoes(inquilinoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


}

