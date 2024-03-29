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
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoPutDTO;
import sis.apartamentos.com.br.api.v1.dto.inquilino.InquilinoResponseDTO;
import sis.apartamentos.com.br.infra.exception.handler.Problema;
import sis.apartamentos.com.br.domain.model.Inquilino;

@Api(tags = "Inquilino")
public interface InquilinoControllerOpenApi {

	@ApiOperation("Busca todos inquilinos paginados por filtro")
	Page<Inquilino> pesquisar(InquilinoFilterDTO inquilinoFilterDTO, Pageable pageable);
	
	@ApiOperation("Busca todos inquilinos sem paginação")
	List<InquilinoResponseDTO> listar();
	
	@ApiOperation("Busca todos inquilinos ativos sem paginação")
	List<InquilinoResponseDTO> listarAtivos();

	@ApiOperation("Cria um novo inquilino")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Inquilino cadastrado"),
    })
	InquilinoResponseDTO criar(@ApiParam(name = "corpo", value = "Representação de um inquilino") InquilinoPostDTO inquilinoPostDTO, HttpServletResponse response);

	@ApiOperation("Atualiza inquilino por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de valor inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class),	 
	 })
	InquilinoResponseDTO atualizar(
			@ApiParam(value = "ID de uma inquilino", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um inquilino")
			InquilinoPutDTO inquilinoPutDTO);
	
	@ApiOperation("Deleta um inquilino por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Inquilino excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class)		
	})
	void remover(@ApiParam(value = "ID de inquilino", example = "1") Long id);

	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Inquilino não encontrado", response = Problema.class)		
	})
	InquilinoResponseDTO buscarPeloId(@ApiParam(value = "ID de um inquilino", example = "1") Long id);
	
}
