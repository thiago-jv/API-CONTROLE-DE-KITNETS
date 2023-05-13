package sis.apartamentos.com.br.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sis.apartamentos.com.br.domain.model.report.ControleLancamentoReport;

@Repository
public interface ControleLancamentorReportRepository extends JpaRepository<ControleLancamentoReport, Long>{
	

}
