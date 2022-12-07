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
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoFilterDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoPostDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoPutDTO;
import sis.apartamentos.com.br.controle.dto.apartamento.ApartamentoResponseDTO;
import sis.apartamentos.com.br.exception.handler.Problema;
import sis.apartamentos.com.br.model.Apartamento;

@Api(tags = "Apartamento")
public interface ApartamentoControllerOpenApi {
	
	@ApiOperation("Busca todos apartamentos paginados")
	Page<Apartamento> pesquisar(ApartamentoFilterDTO apartamentoFilterDTO, Pageable pageable);
	
	@ApiOperation("Busca todos apartamentos sem paginação")
	List<ApartamentoResponseDTO> listar();
	
	@ApiOperation("Busca todos valores sem paginação")
	List<ApartamentoResponseDTO> listarDisponiveis();
	
	@ApiOperation("Cria um novo apartamento")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Apartamento cadastrado"),
    })
	ApartamentoResponseDTO criar(
			@ApiParam(name = "corpo", value = "Representação de um apartamento") ApartamentoPostDTO apartamentoPostDTO, HttpServletResponse response);
	
	@ApiOperation("Deleta um apartamento por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Apartamento excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class)		
	})
	void remover(@ApiParam(value = "ID de apartamento", example = "1") Long id);
	
	@ApiOperation("Atualiza apartamento por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de apartamento inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class),	 
	 })
	ApartamentoResponseDTO atualizar(
			@ApiParam(value = "ID de um apartamento", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um apartamento")
			ApartamentoPutDTO apartamentoPutDTO);
	
	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Apartamento não encontrado", response = Problema.class)		
	})
	ApartamentoResponseDTO buscarPeloId(@ApiParam(value = "ID de uma cidade", example = "1") Long id);
	
	
}