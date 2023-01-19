package sis.apartamentos.com.br.domain.repository.controle;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.infra.filter.LancamentoControleFilter;
import sis.apartamentos.com.br.domain.repository.filter.ControleFilter;

public interface ControleLancamentoRepositoryQuery {

	List<ControleLancamento> buscarControlesLancamentos(LancamentoControleFilter filtro);
	
	Page<ControleLancamento> filtrar(ControleFilter controleFilter, Pageable pageable);
	
}
