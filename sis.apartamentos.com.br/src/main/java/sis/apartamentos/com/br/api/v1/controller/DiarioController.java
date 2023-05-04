package sis.apartamentos.com.br.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioPostDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioResponseDTO;
import sis.apartamentos.com.br.api.v1.icontroller.DiarioControllerOpenApi;
import sis.apartamentos.com.br.api.v1.mapper.DiarioMapper;
import sis.apartamentos.com.br.domain.model.Diario;
import sis.apartamentos.com.br.domain.repository.DiarioRepository;
import sis.apartamentos.com.br.infra.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.infra.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.infra.exception.NegocioException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.Serializable;

@RestController
@RequestMapping(value = "/v1/diarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiarioController implements Serializable, DiarioControllerOpenApi {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Autowired
    private DiarioRepository diarioRepository;

    @Autowired
    private DiarioMapper diarioMapper;

    @GetMapping
    @Override
    public Page<Diario> pesquisar(DiarioFilterDTO diarioFilterDTO, Pageable pageable) {
        return diarioRepository.filtrar(diarioFilterDTO, pageable);
    }

    @PostMapping
    @Override
    public DiarioResponseDTO criar(@Valid @RequestBody DiarioPostDTO diarioPostDTO, HttpServletResponse response) {
        try {
            return diarioMapper.toDiarioResponseDTO(diarioRepository.save(diarioMapper.toDiario(diarioPostDTO)));
        } catch (EntidadeNaoEncontradaException | EntidadeRestricaoDeDadosException e) {
            throw new NegocioException(e.getMessage());
        }
    }
}
