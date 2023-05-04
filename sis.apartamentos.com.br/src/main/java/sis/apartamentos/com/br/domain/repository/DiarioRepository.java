package sis.apartamentos.com.br.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sis.apartamentos.com.br.domain.model.Diario;
import sis.apartamentos.com.br.domain.repository.diario.DiarioRepositoryQuery;

@Repository
public interface DiarioRepository extends JpaRepository<Diario, Long>, DiarioRepositoryQuery {
}
