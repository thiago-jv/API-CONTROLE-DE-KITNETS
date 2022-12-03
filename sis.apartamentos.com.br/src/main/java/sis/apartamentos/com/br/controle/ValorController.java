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

import sis.apartamentos.com.br.controle.dto.ValorFilterDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorPostDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.controle.dto.valor.ValorResponseDTO;
import sis.apartamentos.com.br.controle.mapper.ValorMapper;
import sis.apartamentos.com.br.exception.EntidadeNaoEncontradaException;
import sis.apartamentos.com.br.exception.EntidadeRestricaoDeDadosException;
import sis.apartamentos.com.br.exception.NegocioException;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.openapi.controle.ValorControllerOpenApi;
import sis.apartamentos.com.br.repository.ValorRepository;
import sis.apartamentos.com.br.service.ValorService;

@RestController
@RequestMapping(value = "/valores", produces = MediaType.APPLICATION_JSON_VALUE)
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
    public Page<Valor> pesquisar(ValorFilterDTO valorFilterDTO, Pageable pageable) {
        return valorRepository.filtrar(valorFilterDTO, pageable);
    }

    @GetMapping("/todos")
    @Override
    public List<ValorResponseDTO> listar() {
        return valorMapper.toListValorResponse(valorRepository.listaValores());
    }

    @GetMapping("/{id}")
    @Override
    public ValorResponseDTO buscarPeloId(@PathVariable Long id) {
        return valorMapper.toValorResponse(valorService.buscarOuFalhar(id));
    }

    @PostMapping
    @Override
    public ValorResponseDTO criar(@Valid @RequestBody ValorPostDTO valorPostDTO, HttpServletResponse response) {
        try {
            return valorMapper.toValorResponse(valorRepository.save(valorMapper.toValor(valorPostDTO)));
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage());
        } catch (EntidadeRestricaoDeDadosException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Override
    public ValorResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ValorPutDTO valorPutDTO) {
        return valorMapper.toValorResponse(this.valorService.atualizar(id, valorPutDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Override
    public void remover(@PathVariable Long id) {
        valorService.excluir(id);
    }

}