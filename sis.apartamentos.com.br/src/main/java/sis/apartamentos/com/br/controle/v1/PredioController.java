package sis.apartamentos.com.br.controle.v1;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sis.apartamentos.com.br.controle.v1.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.predio.PredioResponseDTO;
import sis.apartamentos.com.br.controle.v1.mapper.PredioMapper;
import sis.apartamentos.com.br.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.exception.NegocioException;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.openapi.controle.PredioControllerOpenApi;
import sis.apartamentos.com.br.repository.PredioRepository;
import sis.apartamentos.com.br.rest.ApiCep;
import sis.apartamentos.com.br.service.PredioService;

@RestController
@RequestMapping(value = "/v1/predios", produces = MediaType.APPLICATION_JSON_VALUE)
public class PredioController implements Serializable, PredioControllerOpenApi {

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

	@Autowired
	private PredioMapper predioMapper;

	@GetMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PREDIO') and hasAuthority('SCOPE_read')" )
	public Page<Predio> pesquisar(PredioFilterDTO predioFilterDTO, Pageable pageable) {
		return predioRepository.filtrar(predioFilterDTO, pageable);
	}

	@GetMapping("/todos")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PREDIO') and hasAuthority('SCOPE_read')" )
	public List<PredioResponseDTO> listar() {
		return predioMapper.toListPredioResponse(predioRepository.findAll());
	}

	@PostMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PREDIO') and hasAuthority('SCOPE_write')" )
	public PredioResponseDTO criar(@Valid @RequestBody PredioPostDTO predioPostDTO, HttpServletResponse response) {
		try {
			return predioMapper.toPredioResponse(predioRepository.save(predioMapper.toPredio(predioPostDTO)));
		} catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	@PreAuthorize("hasAuthority('ROLE_REMOVER_PREDIO') and hasAuthority('SCOPE_write')" )
	public void remover(@PathVariable Long id) {
		predioService.excluir(id);
	}

	@PutMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PREDIO') and hasAuthority('SCOPE_write')" )
	public PredioResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PredioPutDTO predioPutDTO) {
		return predioMapper.toPredioResponse(this.predioService.atualizar(id, predioPutDTO));
	}

	@GetMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PREDIO') and hasAuthority('SCOPE_read')" )
	public PredioResponseDTO buscarPeloId(@PathVariable Long id) {
		return predioMapper.toPredioResponse(predioService.buscarOuFalhar(id));
	}

	@GetMapping(value = "/cep/{cep}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PREDIO') and hasAuthority('SCOPE_read')" )
	public PredioResponseDTO doObterCep(@PathVariable(name = "cep") String cep) {
    return predioMapper.toPredioResponse(apiCep.request(cep));

	}

}
