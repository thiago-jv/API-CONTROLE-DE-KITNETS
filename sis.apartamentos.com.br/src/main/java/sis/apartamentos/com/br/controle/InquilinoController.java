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
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.InquilinoRepository;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;
import sis.apartamentos.com.br.service.InquilinoService;

@RestController
@RequestMapping(value = "/inquilinos", produces = MediaType.APPLICATION_JSON_VALUE)
public class InquilinoController {

	@Autowired
	private InquilinoRepository inquilinoRepository;

	@Autowired
	private InquilinoService inquilinoService;
	
	@GetMapping
	public Page<Inquilino> pesquisar(InquilinoFilter inquilinoFilter, Pageable pageable) {
		return inquilinoRepository.filtrar(inquilinoFilter, pageable);
	}

	@GetMapping("/todos")
	public List<Inquilino> listar() {
		return inquilinoRepository.findAll();
	}
	
	@GetMapping("/todos/ativos")
	public List<Inquilino> listarAtivos() {
		return inquilinoRepository.listaInquilinosAtivos();
	}
	
	@PostMapping
	public Inquilino criar(@Valid @RequestBody Inquilino inquilino, HttpServletResponse response) {
		Inquilino inquilinoSalva = inquilinoRepository.save(inquilino);
		try {
			return inquilinoSalva;
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		} catch (EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		inquilinoService.excluir(id);
	}

	@PutMapping("/{id}")
	public Inquilino atualizar(@PathVariable Long id, @Valid @RequestBody Inquilino inquilino) {
		return this.inquilinoService.atualizar(id, inquilino);
	}
	
	@GetMapping("/{id}")
	public Inquilino buscarPeloId(@PathVariable Long id) {
		Inquilino inquilino = inquilinoService.buscarOuFalhar(id);
		return inquilino;
	}

}

