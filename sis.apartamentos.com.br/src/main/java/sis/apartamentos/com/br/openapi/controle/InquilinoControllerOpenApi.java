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
import sis.apartamentos.com.br.exception.handler.Problema;
import sis.apartamentos.com.br.model.Inquilino;
import sis.apartamentos.com.br.repository.filter.InquilinoFilter;

@Api(tags = "Inquilino")
public interface InquilinoControllerOpenApi {

	@ApiOperation("Busca todos inquilinos paginados por filtro")
	public Page<Inquilino> pesquisar(InquilinoFilter inquilinoFilter, Pageable pageable);
	
	@ApiOperation("Busca todos inquilinos sem paginação")
	public List<Inquilino> listar();
	
	@ApiOperation("Busca todos inquilinos ativos sem paginação")
	public List<Inquilino> listarAtivos();

	@ApiOperation("Cria um novo inquilino")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Inquilino cadastrado"),
    })
	public Inquilino criar(@ApiParam(name = "corpo", value = "Representação de um inquilino") Inquilino inquilino, HttpServletResponse response);

	@ApiOperation("Atualiza inquilino por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de valor inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class),	 
	 })
	public Inquilino atualizar(
			@ApiParam(value = "ID de uma inquilino", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um inquilino")
			Inquilino inquilino);
	
	@ApiOperation("Deleta um inquilino por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Inquilino excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class)		
	})
	public void remover(@ApiParam(value = "ID de inquilino", example = "1") Long id);

	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class)		
	})
	public Inquilino buscarPeloId(@ApiParam(value = "ID de um inquilino", example = "1") Long id);
	
}