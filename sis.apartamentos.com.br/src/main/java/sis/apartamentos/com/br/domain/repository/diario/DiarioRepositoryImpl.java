package sis.apartamentos.com.br.domain.repository.diario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioFilterDTO;
import sis.apartamentos.com.br.api.v1.mapper.DiarioMapper;
import sis.apartamentos.com.br.domain.model.Diario;
import sis.apartamentos.com.br.domain.repository.filter.DiarioFilter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiarioRepositoryImpl implements DiarioRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private DiarioMapper diarioMapper;
    @Override
    public Page<Diario> filtrar(DiarioFilterDTO diarioFilterDTO, Pageable pageable) {
        DiarioFilter diarioFilter = diarioMapper.toDiarioFilterDTO(diarioFilterDTO);
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Diario> criteria = builder.createQuery(Diario.class);
        Root<Diario> root = criteria.from(Diario.class);

        criteria.orderBy(builder.asc(root.get("id")));

        Predicate[] predicates = criarRestricoes(diarioFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Diario> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(diarioFilter));
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(DiarioFilter diarioFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Diario> root = criteria.from(Diario.class);

        Predicate[] predicates = criarRestricoes(diarioFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private Predicate[] criarRestricoes(DiarioFilter diarioFilter, CriteriaBuilder builder,
                                        Root<Diario> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!Objects.isNull(diarioFilter.getDescricao())) {

            predicates.add(builder.like((root.get("descricao")),
                    "%" + diarioFilter.getDescricao() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
