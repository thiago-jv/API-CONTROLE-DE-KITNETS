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
import sis.apartamentos.com.br.model.Valor;
import sis.apartamentos.com.br.repository.filter.ValorFilter;

@Api(tags = "Valor")
public interface ValorControllerOpenApi {

	@ApiOperation("Busca todos valores paginados")
	public Page<Valor> pesquisar(ValorFilter valorFilter, Pageable pageable);
	
	@ApiOperation("Busca todos valores sem paginação")
	public List<Valor> listar();

	@ApiOperation("Cria um novo valor")
	public Valor criar(@ApiParam(name = "corpo", value = "Representação de um valor") Valor valor, HttpServletResponse response);

	@ApiOperation("Atualiza valor por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de valor inválido"),
		 @ApiResponse(code = 404, message = "Valor não encontrado")	 
	 })
	public Valor atualizar(
			@ApiParam(value = "ID de uma cidade", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um valor")
			Valor valor);
	
	@ApiOperation("Deleta um valor por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Valor excluido"),
		@ApiResponse(code = 404, message = "Valor não encontrado")		
	})
	public void remover(@ApiParam(value = "ID de valor", example = "1") Long id);

}