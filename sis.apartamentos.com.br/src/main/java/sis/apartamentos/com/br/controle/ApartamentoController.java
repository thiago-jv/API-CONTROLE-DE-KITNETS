package sis.apartamentos.com.br.controle;

import java.io.Serializable;
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
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.ApartamentoRepository;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;
import sis.apartamentos.com.br.service.ApartamentoService;

@RestController
@RequestMapping(value = "/apartamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ApartamentoService apartamentoService;

	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	@GetMapping
	public Page<Apartamento> pesquisar(ApartamentoFilter apartamentoFilter, Pageable pageable) {
		return apartamentoRepository.filtrar(apartamentoFilter, pageable);
	}

	@GetMapping("/todos")
	public List<Apartamento> listar() {
		return apartamentoRepository.findAll();
	}
	
	@GetMapping("/todos/disponiveis")
	public List<Apartamento> listarDisponiveis() {
		return apartamentoRepository.listaApartamentosDisponiveis();
	}
	
	@PostMapping
	public Apartamento criar(@Valid @RequestBody Apartamento apartamento, HttpServletResponse response) {
		Apartamento apartamentoSalva = apartamentoRepository.save(apartamento);
		try {
			return apartamentoSalva;
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		} catch (EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		apartamentoService.excluir(id);
	}

	@PutMapping("/{id}")
	public Apartamento atualizar(@PathVariable Long id, @Valid @RequestBody Apartamento apartamento) {
		return this.apartamentoService.atualizar(id, apartamento);
	}
	
	@GetMapping("/{id}")
	public Apartamento buscarPeloId(@PathVariable Long id) {
		Apartamento apartamento = apartamentoService.buscarOuFalhar(id);
		return apartamento;
	}


}
