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

import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoPutDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoResponseDTO;
import sis.apartamentos.com.br.api.v1.mapper.InquilinoMapper;
import sis.apartamentos.com.br.infra.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.infra.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.infra.exception.NegocioException;
import sis.apartamentos.com.br.domain.model.Inquilino;
import sis.apartamentos.com.br.api.v1.icontroller.InquilinoControllerOpenApi;
import sis.apartamentos.com.br.domain.repository.InquilinoRepository;
import sis.apartamentos.com.br.domain.service.InquilinoService;

@RestController
@RequestMapping(value = "/v1/inquilinos", produces = MediaType.APPLICATION_JSON_VALUE)
public class InquilinoController implements Serializable, InquilinoControllerOpenApi {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Autowired
    private InquilinoService inquilinoService;

    @Autowired
    private InquilinoMapper inquilinoMapper;

    @GetMapping
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_read')" )
    public Page<Inquilino> pesquisar(InquilinoFilterDTO inquilinoFilterDTO, Pageable pageable) {
        return inquilinoRepository.filtrar(inquilinoFilterDTO, pageable);
    }

    @GetMapping("/todos")
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_read')" )
    public List<InquilinoResponseDTO> listar() {
        return inquilinoMapper.toListInquilinoResponse(inquilinoRepository.findAll());
    }

    @GetMapping("/todos/ativos")
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_read')" )
    public List<InquilinoResponseDTO> listarAtivos() {
        return inquilinoMapper.toListInquilinoResponse(inquilinoRepository.listaInquilinosAtivos());
    }

    @PostMapping
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_write')" )
    public InquilinoResponseDTO criar(@Valid @RequestBody InquilinoPostDTO inquilinoPostDTO, HttpServletResponse response) {
        try {
            return inquilinoMapper.toInquilinoResponse(inquilinoRepository.save(inquilinoMapper.toInquilino(inquilinoPostDTO)));
        } catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_write')" )
    public void remover(@PathVariable Long id) {
        inquilinoService.excluir(id);
    }

    @PutMapping("/{id}")
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_write')" )
    public InquilinoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody InquilinoPutDTO inquilinoPutDTO) {
        return inquilinoMapper.toInquilinoResponse(this.inquilinoService.atualizar(id, inquilinoPutDTO));
    }

    @GetMapping("/{id}")
    @Override
    @PreAuthorize("hasAuthority('ROLE_INQUILINO') and hasAuthority('SCOPE_read')" )
    public InquilinoResponseDTO buscarPeloId(@PathVariable Long id) {
        return inquilinoMapper.toInquilinoResponse(inquilinoService.buscarOuFalhar(id));
    }

}

