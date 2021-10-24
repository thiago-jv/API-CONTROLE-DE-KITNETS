package sis.apartamentos.com.br.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.apartamento.ApartamentoRepositoryQuery;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>, ApartamentoRepositoryQuery{

	@Query("select a from Apartamento a")
	List<Apartamento> listaApartamentosDisponiveis();
	
}
