package sis.apartamentos.com.br.domain.repository.controle;

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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.domain.repository.filter.ControleFilter;
import sis.apartamentos.com.br.infra.filter.LancamentoControleFilter;
import sis.apartamentos.com.br.domain.model.ControleLancamento;

public class ControleLancamentoRepositoryImpl implements ControleLancamentoRepositoryQuery{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<ControleLancamento> filtrar(ControleFilter controleFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ControleLancamento> criteria = builder.createQuery(ControleLancamento.class);
		Root<ControleLancamento> root = criteria.from(ControleLancamento.class);
		
		criteria.orderBy(builder.asc(root.get("status").get("statusControle")));
		
		Predicate[] predicates = criarRestricoes(controleFilter, builder, root);
		criteria.where(predicates);
		

		TypedQuery<ControleLancamento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(controleFilter));
	}

	private static String DATA_PAGAMENTO = "dataPagamento";
	
	private Predicate[] criarRestricoes(ControleFilter controleFilter, CriteriaBuilder builder,
			Root<ControleLancamento> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		if (controleFilter.getDataPagamentoDe() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get(DATA_PAGAMENTO),
					controleFilter.getDataPagamentoDe()));
		}

		if (controleFilter.getDataPagamentoAte() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get(DATA_PAGAMENTO),
					controleFilter.getDataPagamentoAte()));
		}
		
		if (!Objects.isNull(controleFilter.getEntragaContaLuz())) {
			predicates.add(builder.equal((root.get("status").get("entragaContaLuz")), controleFilter.getEntragaContaLuz()));
		}
		
		if (!Objects.isNull(controleFilter.getStatusApartamePagamentoLuz())) {
			predicates.add(builder.equal((root.get("status").get("statusApartamePagamentoLuz")), controleFilter.getStatusApartamePagamentoLuz()));
		}
		
		if (!Objects.isNull(controleFilter.getStatusApartamePagamento())) {
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

	@Override
	public List<ControleLancamento> buscarControlesLancamentos(LancamentoControleFilter filtro) {
		var builder = manager.getCriteriaBuilder();
		var query = builder.createQuery(ControleLancamento.class);
		var root = query.from(ControleLancamento.class);
		
		var predicates = new ArrayList<Predicate>();
		
		if (filtro.getDataInicio() != null) {
		    predicates.add(builder.greaterThanOrEqualTo(root.get("dataPagamento"), 
		            filtro.getDataInicio()));
		}

		if (filtro.getDataFim() != null) {
		    predicates.add(builder.lessThanOrEqualTo(root.get("dataPagamento"), 
		            filtro.getDataFim()));
		}
		
		query.where(predicates.toArray(new Predicate[0]));
		
		return manager.createQuery(query).getResultList();	
	}

}
