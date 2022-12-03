package sis.apartamentos.com.br.openapi.controle;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sis.apartamentos.com.br.controle.dto.ValorFilterDTO;
import sis.apartamentos.com.br.exception.handler.Problema;
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

@Api(tags = "Valor")
public interface ValorControllerOpenApi {

	@ApiOperation("Busca todos valores paginados")
	public Page<Valor> pesquisar(ValorFilterDTO valorFilterDTO, Pageable pageable);
	
	@ApiOperation("Busca todos valores sem paginação")
	public List<Valor> listar();

	@ApiOperation("Cria um novo valor")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Valor cadastrado"),
    })
	public Valor criar(@ApiParam(name = "corpo", value = "Representação de um valor") Valor valor, HttpServletResponse response);

	@ApiOperation("Atualiza valor por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de valor inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class),	 
	 })
	public Valor atualizar(
			@ApiParam(value = "ID de um valor", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um valor")
			Valor valor);
	
	@ApiOperation("Deleta um valor por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Valor excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class)		
	})
	public void remover(@ApiParam(value = "ID de valor", example = "1") Long id);

	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class)		
	})
	public Valor buscarPeloId(@ApiParam(value = "ID de uma cidade", example = "1") Long id);
	
}