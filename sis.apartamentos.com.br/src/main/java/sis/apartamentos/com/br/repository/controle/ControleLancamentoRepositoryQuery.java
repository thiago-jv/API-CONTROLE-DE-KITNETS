package sis.apartamentos.com.br.repository.controle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.repository.filter.ControleFilter;

public interface ControleLancamentoRepositoryQuery {

	Page<ControleLancamento> filtrar(ControleFilter controleFilter, Pageable pageable);
	
}
