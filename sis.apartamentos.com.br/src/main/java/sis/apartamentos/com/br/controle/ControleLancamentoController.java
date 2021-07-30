package sis.apartamentos.com.br.controle;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sis.apartamentos.com.br.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.exception.NegocioException;
import sis.apartamentos.com.br.model.ControleLancamento;
import sis.apartamentos.com.br.repository.ControleLancamentoRepository;
import sis.apartamentos.com.br.repository.filter.ControleFilter;
import sis.apartamentos.com.br.service.ControleLancamentoService;

@RestController
@RequestMapping(value = "/controles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControleLancamentoController {

	@Autowired
	private ControleLancamentoRepository controleLancamentoRepository;

	@Autowired
	private ControleLancamentoService controleLancamentoService;

	@GetMapping
	public Page<ControleLancamento> pesquisar(ControleFilter controleFilter, Pageable pageable) {
		return controleLancamentoRepository.filtrar(controleFilter, pageable);
	}

	@GetMapping("/todos")
	public List<ControleLancamento> listar() {
		return controleLancamentoRepository.findAll();
	}

	@PostMapping
	public ControleLancamento criar(@Valid @RequestBody ControleLancamento controleLancamento,
			HttpServletResponse response) {
		ControleLancamento controleSalva = controleLancamentoService.salvar(controleLancamento);
		try {
			return controleSalva;
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		} catch (EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		controleLancamentoService.excluir(id);
	}

	@PutMapping("/{id}")
	public ControleLancamento atualizar(@PathVariable Long id,
			@Valid @RequestBody ControleLancamento controleLancamento) {
		return this.controleLancamentoService.atualizar(id, controleLancamento);
	}

	@GetMapping("/{id}")
	public ControleLancamento buscarPeloId(@PathVariable Long id) {
		ControleLancamento controleLancamento = controleLancamentoService.buscarOuFalhar(id);
		return controleLancamento;
	}

	@PutMapping("/{id}/status")
	public void atualizarPropriedadeStatus(@PathVariable Long id) {
		controleLancamentoService.atualizarPropriedadeStatus(id);
	}
	
	
}
