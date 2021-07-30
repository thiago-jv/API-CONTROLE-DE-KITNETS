package sis.apartamentos.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.predio.PredioRepositoryQuery;
	
@Repository
public interface PredioRepository extends JpaRepository<Predio, Long>, PredioRepositoryQuery{
	
}
