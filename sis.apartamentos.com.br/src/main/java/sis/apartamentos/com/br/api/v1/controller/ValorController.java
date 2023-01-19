package sis.apartamentos.com.br.api.v1.controller;

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

import sis.apartamentos.com.br.api.v1.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorPostDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorResponseDTO;
import sis.apartamentos.com.br.api.v1.mapper.ValorMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.infra.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.infra.exception.NegocioException;
import sis.apartamentos.com.br.domain.model.Valor;
import sis.apartamentos.com.br.api.v1.icontroller.ValorControllerOpenApi;
import sis.apartamentos.com.br.domain.repository.ValorRepository;
import sis.apartamentos.com.br.domain.service.ValorService;

@RestController
@RequestMapping(value = "/v1/valores", produces = MediaType.APPLICATION_JSON_VALUE)
public class ValorController implements Serializable, ValorControllerOpenApi {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private ValorRepository valorRepository;

    @Autowired
    private ValorService valorService;

    @Autowired
    private ValorMapper valorMapper;

    @GetMapping
    @Override
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_VALOR') and hasAuthority('SCOPE_read')" )
    public Page<Valor> pesquisar(ValorFilterDTO valorFilterDTO, Pageable pageable) {
        return valorRepository.filtrar(valorFilterDTO, pageable);
    }

    @GetMapping("/todos")
    @Override
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_VALOR') and hasAuthority('SCOPE_read')" )
    public List<ValorResponseDTO> listar() {
        return valorMapper.toListValorResponse(valorRepository.listaValores());
    }

    @GetMapping("/{id}")
    @Override
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_VALOR') and hasAuthority('SCOPE_read')" )
    public ValorResponseDTO buscarPeloId(@PathVariable Long id) {
        return valorMapper.toValorResponse(valorService.buscarOuFalhar(id));
    }

    @PostMapping
    @Override
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_VALOR') and hasAuthority('SCOPE_write')" )
    public ValorResponseDTO criar(@Valid @RequestBody ValorPostDTO valorPostDTO, HttpServletResponse response) {
        try {
            return valorMapper.toValorResponse(valorRepository.save(valorMapper.toValor(valorPostDTO)));
        } catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Override
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_VALOR') and hasAuthority('SCOPE_write')" )
    public ValorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ValorPutDTO valorPutDTO) {
        return valorMapper.toValorResponse(this.valorService.atualizar(id, valorPutDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    @PreAuthorize("hasAuthority('ROLE_REMOVER_VALOR') and hasAuthority('SCOPE_write')" )
    public void remover(@PathVariable Long id) {
        valorService.excluir(id);
    }

}
