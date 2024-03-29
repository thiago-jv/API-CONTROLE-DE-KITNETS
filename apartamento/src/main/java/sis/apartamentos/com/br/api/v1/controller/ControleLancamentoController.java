package sis.apartamentos.com.br.api.v1.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoResponseDTO;
import sis.apartamentos.com.br.api.v1.mapper.ControleLancamentoMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.infra.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.infra.exception.NegocioException;
import sis.apartamentos.com.br.infra.filter.LancamentoControleFilter;
import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.api.v1.icontroller.ControleLancamentoControllerOpenApi;
import sis.apartamentos.com.br.domain.repository.ControleLancamentoRepository;
import sis.apartamentos.com.br.domain.repository.filter.ControleFilter;
import sis.apartamentos.com.br.domain.service.ControleLancamentoService;

@RestController
@RequestMapping(value = "/v1/controles", produces = MediaType.APPLICATION_JSON_VALUE)
public class ControleLancamentoController implements Serializable, ControleLancamentoControllerOpenApi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ControleLancamentoRepository controleLancamentoRepository;

	@Autowired
	private ControleLancamentoService controleLancamentoService;

	@Autowired
	private ControleLancamentoMapper controleLancamentoMapper;

	@GetMapping("/estatistica/por-apartamento")
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public List<ControleLancamentoResponseDTO> porApartamento(LancamentoControleFilter filtro){
		return controleLancamentoMapper.toListControleLancamentoResponse(controleLancamentoRepository.buscarControlesLancamentos(filtro));
	}
	
	@GetMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public Page<ControleLancamento> pesquisar(ControleFilter controleFilter, Pageable pageable) {
		return controleLancamentoRepository.filtrar(controleFilter, pageable);
	}

	@GetMapping("/todos")
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public List<ControleLancamentoResponseDTO> listar() {
		return controleLancamentoMapper.toListControleLancamentoResponse(controleLancamentoRepository.findAll());
	}

	@PostMapping
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_write')" )
	public ControleLancamentoResponseDTO criar(@Valid @RequestBody ControleLancamentoPostDTO controleLancamento,
											   HttpServletResponse response) {
		try {
			 return controleLancamentoMapper.toControleLancamentoResponse(controleLancamentoService.salvar(controleLancamento));
		} catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_write')" )
	public void remover(@PathVariable Long id) {
		controleLancamentoService.excluir(id);
	}

	@PutMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_write')" )
	public ControleLancamentoResponseDTO atualizar(@PathVariable Long id,
			@Valid @RequestBody ControleLancamentoPutDTO controleLancamento) {
		return controleLancamentoMapper.toControleLancamentoResponse(controleLancamentoService.atualizar(id, controleLancamento));
	}
	
	@PutMapping("/{id}/status")
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_write')" )
	public void atualizarStatus(@PathVariable Long id) {
	   this.controleLancamentoService.atualizarPropriedadeStatus(id);
	}
	
	@GetMapping("/{id}")
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public ControleLancamentoResponseDTO buscarPeloId(@PathVariable Long id) {
		return controleLancamentoMapper.toControleLancamentoResponse(controleLancamentoService.buscarOuFalhar(id));
	}
	
	@GetMapping(path = "/relatorio/por-controle-lancamento", produces = MediaType.APPLICATION_PDF_VALUE)
	@Override
	@PreAuthorize("hasAuthority('ROLE_LANCAMENTO') and hasAuthority('SCOPE_read')" )
	public ResponseEntity<byte[]> relatorioPorLancamentoControlePdf(Long idLancamento) {
		byte[] bytesPdf = controleLancamentoService.relatorioDeLancamentos(idLancamento);
		
		var headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=controle-lancamento.pdf");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.headers(headers)
				.body(bytesPdf);
	}
	
	
}
