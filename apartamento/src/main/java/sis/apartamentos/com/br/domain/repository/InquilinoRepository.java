package sis.apartamentos.com.br.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.domain.model.Inquilino;
import sis.apartamentos.com.br.domain.repository.inquilino.InquilinoRepositoryQuery;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long>, InquilinoRepositoryQuery {

	@Query("select i from Inquilino i "
			+ "where i.status in('ATIVO')")
	List<Inquilino> listaInquilinosAtivos();
	
}
