package sis.apartamentos.com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.valor.ValorRepositoryQuery;

import java.util.List;

@Repository
public interface ValorRepository extends JpaRepository<Valor, Long>, ValorRepositoryQuery{

    @Query("select v from ValorDTO v")
    List<Valor> listaValores();
}
