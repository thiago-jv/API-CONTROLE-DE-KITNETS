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

import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPostDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.v1.dto.apartamento.ApartamentoResponseDTO;
import sis.apartamentos.com.br.controle.v1.mapper.ApartamentoMapper;
import sis.apartamentos.com.br.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.exception.NegocioException;
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.openapi.controle.ApartamentoControllerOpenApi;
import sis.apartamentos.com.br.repository.ApartamentoRepository;
import sis.apartamentos.com.br.service.ApartamentoService;

@RestController
@RequestMapping(value = "/v1/apartamentos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartamentoController implements Serializable, ApartamentoControllerOpenApi {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ApartamentoService apartamentoService;

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	@Autowired
	private ApartamentoMapper apartamentoMapper;
	
	@GetMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_APARTAMENTO') and hasAuthority('SCOPE_read')" )
	public Page<Apartamento> pesquisar(ApartamentoFilterDTO apartamentoFilterDTO, Pageable pageable) {
		return apartamentoRepository.filtrar(apartamentoFilterDTO, pageable);
	}

	@GetMapping("/todos")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_APARTAMENTO') and hasAuthority('SCOPE_read')" )
	public List<ApartamentoResponseDTO> listar() {
		return apartamentoMapper.toListApartamentoResponse(apartamentoRepository.findAll());
	}
	
	@GetMapping("/todos/disponiveis")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_APARTAMENTO') and hasAuthority('SCOPE_read')" )
	public List<ApartamentoResponseDTO> listarDisponiveis() {
		return apartamentoMapper.toListApartamentoResponse(apartamentoRepository.listaApartamentosDisponiveis());
	}
	
	@PostMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_APARTAMENTO') and hasAuthority('SCOPE_write')" )
	public ApartamentoResponseDTO criar(@Valid @RequestBody ApartamentoPostDTO apartamentoPostDTO, HttpServletResponse response) {
		try {
			return apartamentoMapper.toApartamentoResponse(apartamentoRepository.save(apartamentoMapper.toApartamento(apartamentoPostDTO)));
		} catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	@PreAuthorize("hasAuthority('ROLE_REMOVER_APARTAMENTO') and hasAuthority('SCOPE_write')" )
	public void remover(@PathVariable Long id) {
		apartamentoService.excluir(id);
	}

	@PutMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_INQUILINO') and hasAuthority('SCOPE_write')" )
	public ApartamentoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ApartamentoPutDTO apartamentoPutDTO) {
		return apartamentoMapper.toApartamentoResponse(this.apartamentoService.atualizar(id, apartamentoPutDTO));
	}
	
	@GetMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_APARTAMENTO') and hasAuthority('SCOPE_read')" )
	public ApartamentoResponseDTO buscarPeloId(@PathVariable Long id) {
		return apartamentoMapper.toApartamentoResponse(apartamentoService.buscarOuFalhar(id));
	}


}
