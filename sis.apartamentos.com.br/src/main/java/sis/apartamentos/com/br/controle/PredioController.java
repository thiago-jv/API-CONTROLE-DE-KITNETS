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
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.PredioRepository;
import sis.apartamentos.com.br.repository.filter.PredioFilter;
import sis.apartamentos.com.br.rest.ApiCep;
import sis.apartamentos.com.br.service.PredioService;

@RestController
@RequestMapping(value = "/predios", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PredioRepository predioRepository;

	@Autowired
	private PredioService predioService;
	
	@Autowired
	private ApiCep apiCep;

	@GetMapping
	public Page<Predio> pesquisar(PredioFilter predioFilter, Pageable pageable) {
		return predioRepository.filtrar(predioFilter, pageable);
	}

	@GetMapping("/todos")
	public List<Predio> listar() {
		return predioRepository.findAll();
	}

	@PostMapping
	public Predio criar(@Valid @RequestBody Predio predio, HttpServletResponse response) {
		Predio predioSalva = predioRepository.save(predio);
		try {
			return predioSalva;
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		} catch (EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		predioService.excluir(id);
	}

	@PutMapping("/{id}")
	public Predio atualizar(@PathVariable Long id, @Valid @RequestBody Predio predio) {
		return this.predioService.atualizar(id, predio);
	}

	@GetMapping("/{id}")
	public Predio buscarPeloId(@PathVariable Long id) {
		Predio predio = predioService.buscarOuFalhar(id);
		return predio;
	}

	@GetMapping(value = "/cep/{cep}")
	public Predio doObterCep(@PathVariable(name = "cep") String cep) {
    Predio predio = apiCep.request(cep);
    return predio;

	}

}
