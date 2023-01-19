package sis.apartamentos.com.br.api.v1.icontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorPostDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorPutDTO;
import sis.apartamentos.com.br.api.v1.dto.valor.ValorResponseDTO;
import sis.apartamentos.com.br.infra.exception.handler.Problema;
import sis.apartamentos.com.br.domain.model.Valor;

@Api(tags = "Valor")
public interface ValorControllerOpenApi {

	@ApiOperation("Busca todos valores paginados")
	Page<Valor> pesquisar(ValorFilterDTO valorFilterDTO, Pageable pageable);
	
	@ApiOperation("Busca todos valores sem paginação")
	List<ValorResponseDTO> listar();

	@ApiOperation("Cria um novo valor")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Valor cadastrado"),
    })
	ValorResponseDTO criar(@ApiParam(name = "corpo", value = "Representação de um valor") ValorPostDTO valorPostDTO, HttpServletResponse response);

	@ApiOperation("Atualiza valor por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de valor inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class),	 
	 })
	ValorResponseDTO atualizar(
			@ApiParam(value = "ID de um valor", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um valor")
			ValorPutDTO valorPutDTO);
	
	@ApiOperation("Deleta um valor por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Valor excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class)		
	})
	void remover(@ApiParam(value = "ID de valor", example = "1") Long id);

	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Valor não encontrado", response = Problema.class)		
	})
	ValorResponseDTO buscarPeloId(@ApiParam(value = "ID de uma cidade", example = "1") Long id);
	
}
