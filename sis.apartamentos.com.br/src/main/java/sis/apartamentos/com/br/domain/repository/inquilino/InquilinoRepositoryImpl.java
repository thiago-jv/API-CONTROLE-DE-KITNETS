package sis.apartamentos.com.br.domain.repository.inquilino;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.api.v1.mapper.InquilinoMapper;
import sis.apartamentos.com.br.domain.model.Inquilino;
import sis.apartamentos.com.br.domain.repository.filter.InquilinoFilter;

public class InquilinoRepositoryImpl implements InquilinoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private InquilinoMapper inquilinoMapper;
	
	@Override
	public Page<Inquilino> filtrar(InquilinoFilterDTO inquilinoFilterDTO, Pageable pageable) {
		InquilinoFilter inquilinoFilter = inquilinoMapper.toInquilinoFilter(inquilinoFilterDTO);
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Inquilino> criteria = builder.createQuery(Inquilino.class);
		Root<Inquilino> root = criteria.from(Inquilino.class);
		
		criteria.orderBy(builder.asc(root.get("id")));

		Predicate[] predicates = criarRestricoes(inquilinoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Inquilino> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(inquilinoFilter));
	}
	
	private Predicate[] criarRestricoes(InquilinoFilter inquilinoFilter, CriteriaBuilder builder,
			Root<Inquilino> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!Objects.isNull(inquilinoFilter.getNome())) {
			
			predicates.add(builder.like((root.get("nome")),
					"%" + inquilinoFilter.getNome() + "%"));
		}
		
        if (!Objects.isNull(inquilinoFilter.getCpf())) {
			
			predicates.add(builder.like((root.get("cpf")),
					"%" + inquilinoFilter.getCpf() + "%"));
		}
        
        if (!Objects.isNull(inquilinoFilter.getStatus())) {

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

