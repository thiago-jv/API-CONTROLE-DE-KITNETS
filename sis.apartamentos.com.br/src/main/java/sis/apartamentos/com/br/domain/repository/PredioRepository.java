package sis.apartamentos.com.br.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.domain.model.Predio;
import sis.apartamentos.com.br.domain.repository.predio.PredioRepositoryQuery;
	
@Repository
public interface PredioRepository extends JpaRepository<Predio, Long>, PredioRepositoryQuery{
	
}
