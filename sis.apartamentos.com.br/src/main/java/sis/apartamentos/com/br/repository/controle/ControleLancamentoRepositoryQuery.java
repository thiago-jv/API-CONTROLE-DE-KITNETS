package sis.apartamentos.com.br.repository.controle;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.repository.filter.ControleFilter;
import sis.apartamentos.com.br.filter.*;

public interface ControleLancamentoRepositoryQuery {

	List<ControleLancamento> buscarControlesLancamentos(LancamentoControleFilter filtro);
	
	Page<ControleLancamento> filtrar(ControleFilter controleFilter, Pageable pageable);
	
}
