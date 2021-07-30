package sis.apartamentos.com.br.repository.controle;

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

import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.repository.filter.ControleFilter;

public class ControleLancamentoRepositoryImpl implements ControleLancamentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<ControleLancamento> filtrar(ControleFilter controleFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ControleLancamento> criteria = builder.createQuery(ControleLancamento.class);
		Root<ControleLancamento> root = criteria.from(ControleLancamento.class);
		
		Predicate[] predicates = criarRestricoes(controleFilter, builder, root);
		criteria.where(predicates);
		

		TypedQuery<ControleLancamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(controleFilter));
	}
	
	private Predicate[] criarRestricoes(ControleFilter controleFilter, CriteriaBuilder builder,
			Root<ControleLancamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (controleFilter.getDataPagamentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataPagamento"),
					controleFilter.getDataPagamentoDe()));
		}

		if (controleFilter.getDataPagamentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataPagamento"),
					controleFilter.getDataPagamentoAte()));
		}
		
		if (!StringUtils.isEmpty(controleFilter.getEntragaContaLuz())) {
			predicates.add(builder.equal((root.get("status").get("entragaContaLuz")), controleFilter.getEntragaContaLuz()));
		}
		
		if (!StringUtils.isEmpty(controleFilter.getStatusApartamePagamentoLuz())) {
			predicates.add(builder.equal((root.get("status").get("statusApartamePagamentoLuz")), controleFilter.getStatusApartamePagamentoLuz()));
		}
		
		if (!StringUtils.isEmpty(controleFilter.getStatusApartamePagamento())) {
			predicates.add(builder.equal((root.get("status").get("statusApartamePagamento")), controleFilter.getStatusApartamePagamento()));
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
	
	private Long total(ControleFilter controleFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ControleLancamento> root = criteria.from(ControleLancamento.class);

		Predicate[] predicates = criarRestricoes(controleFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}


}