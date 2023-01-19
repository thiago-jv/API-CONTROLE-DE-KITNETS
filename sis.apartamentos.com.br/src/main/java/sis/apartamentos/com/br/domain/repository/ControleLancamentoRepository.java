package sis.apartamentos.com.br.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.domain.repository.controle.ControleLancamentoRepositoryQuery;

@Repository
public interface ControleLancamentoRepository extends JpaRepository<ControleLancamento, Long>, ControleLancamentoRepositoryQuery {
	
	@Query("select a from ControleLancamento a inner join fetch a.inquilino i inner join fetch a.apartamento p "
			+ "where a.dataEntrada between :pDataInico and :pDataFim and i.id = :pIdInquilino or p.id = :pIdApartamento")
	List<ControleLancamento> listaControleLancamentosPorDataDeEntrada(@Param("pIdInquilino") Long pIdInquilino, @Param("pIdApartamento") Long pIdApartamento, @Param("pDataInico") LocalDate pDataInico, @Param("pDataFim") LocalDate pDataFim);

}
