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
import sis.apartamentos.com.br.model.Apartamento;
import sis.apartamentos.com.br.repository.filter.ApartamentoFilter;

@Api(tags = "Apartamento")
public interface ApartamentoControllerOpenApi {
	
	@ApiOperation("Busca todos apartamentos paginados")
	public Page<Apartamento> pesquisar(ApartamentoFilter apartamentoFilter, Pageable pageable);
	
	@ApiOperation("Busca todos apartamentos sem paginação")
	public List<Apartamento> listar();
	
	@ApiOperation("Busca todos valores sem paginação")
	public List<Apartamento> listarDisponiveis();
	
	@ApiOperation("Cria um novo apartamento")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Apartamento cadastrado"),
    })
	public Apartamento criar(
			@ApiParam(name = "corpo", value = "Representação de um apartamento") Apartamento apartamento, HttpServletResponse response);
	
	@ApiOperation("Deleta um apartamento por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Apartamento excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class)		
	})
	public void remover(@ApiParam(value = "ID de apartamento", example = "1") Long id);
	
	@ApiOperation("Atualiza apartamento por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de apartamento inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class),	 
	 })
	public Apartamento atualizar(
			@ApiParam(value = "ID de um apartamento", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um apartamento")
			Apartamento apartamento);
	
	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class)		
	})
	public Apartamento buscarPeloId(@ApiParam(value = "ID de uma cidade", example = "1") Long id);
	
	
}