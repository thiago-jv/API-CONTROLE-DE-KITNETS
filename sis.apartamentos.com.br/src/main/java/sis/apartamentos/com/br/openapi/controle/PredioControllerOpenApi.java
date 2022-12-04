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
import sis.apartamentos.com.br.controle.dto.predio.PredioFilterDTO;
import sis.apartamentos.com.br.controle.dto.predio.PredioPostDTO;
import sis.apartamentos.com.br.controle.dto.predio.PredioPutDTO;
import sis.apartamentos.com.br.controle.dto.predio.PredioResponseDTO;
import sis.apartamentos.com.br.exception.handler.Problema;
import sis.apartamentos.com.br.model.Predio;
import sis.apartamentos.com.br.repository.filter.PredioFilter;

@Api(tags = "Predio")
public interface PredioControllerOpenApi {

	@ApiOperation("Busca todos predios paginados")
	Page<Predio> pesquisar(PredioFilterDTO predioFilterDTO, Pageable pageable);
	
	@ApiOperation("Busca todos valores sem paginação")
	List<PredioResponseDTO> listar();

	@ApiOperation("Cria um novo predio")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Predio cadastrado"),
    })
	PredioResponseDTO criar(PredioPostDTO predioPostDTO, HttpServletResponse response);

	@ApiOperation("Atualiza predio por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID do predio inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Predio não encontrado", response = Problema.class),	 
	 })
	PredioResponseDTO atualizar(
			@ApiParam(value = "ID de uma predio", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um predio")
			PredioPutDTO predioPutDTO);
	
	@ApiOperation("Deleta um predio por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Predio excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Predio não encontrado", response = Problema.class)		
	})
	void remover(@ApiParam(value = "ID de predio", example = "1") Long id);

	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Predio não encontrado", response = Problema.class)		
	})
	PredioResponseDTO buscarPeloId(@ApiParam(value = "ID de uma predio", example = "1") Long id);
	
	@ApiOperation("Busca por cep")
	@ApiResponses({
		@ApiResponse(code = 404, message = "cep não encontrado", response = Problema.class)		
	})
	PredioResponseDTO doObterCep(@ApiParam(value = "Cep", example = "69093118") String cep);
}