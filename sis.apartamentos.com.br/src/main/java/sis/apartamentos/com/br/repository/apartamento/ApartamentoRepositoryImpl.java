package sis.apartamentos.com.br.repository.apartamento;

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

import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;

public class ApartamentoRepositoryImpl implements ApartamentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Apartamento> filtrar(ApartamentoFilter apartamentoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Apartamento> criteria = builder.createQuery(Apartamento.class);
		Root<Apartamento> root = criteria.from(Apartamento.class);

		Predicate[] predicates = criarRestricoes(apartamentoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Apartamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(apartamentoFilter));
	}
	
	private Predicate[] criarRestricoes(ApartamentoFilter apartamentoFilter, CriteriaBuilder builder,
			Root<Apartamento> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(apartamentoFilter.getDesricao())) {
			
			predicates.add(builder.like((root.get("descricao")),
					"%" + apartamentoFilter.getDesricao() + "%"));
		}
		
        if (!StringUtils.isEmpty(apartamentoFilter.getNumero())) {
			
        	predicates.add(builder.equal((root.get("numero")), apartamentoFilter.getNumero()));
		}
        
        if (!StringUtils.isEmpty(apartamentoFilter.getStatusApartamento())) {

			predicates.add(builder.equal((root.get("statusApartamento")), apartamentoFilter.getStatusApartamento()));
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
	
	private Long total(ApartamentoFilter apartamentoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Apartamento> root = criteria.from(Apartamento.class);

		Predicate[] predicates = criarRestricoes(apartamentoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


}