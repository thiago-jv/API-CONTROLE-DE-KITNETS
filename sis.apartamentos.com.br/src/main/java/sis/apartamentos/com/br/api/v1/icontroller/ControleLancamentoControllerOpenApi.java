package sis.apartamentos.com.br.api.v1.icontroller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.sf.jasperreports.engine.JRException;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPostDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoPutDTO;
import sis.apartamentos.com.br.api.v1.dto.controleLancamento.ControleLancamentoResponseDTO;
import sis.apartamentos.com.br.infra.exception.handler.Problema;
import sis.apartamentos.com.br.infra.filter.LancamentoControleFilter;
import sis.apartamentos.com.br.domain.model.ControleLancamento;
import sis.apartamentos.com.br.domain.repository.filter.ControleFilter;

@Api(tags = "Controle")
public interface ControleLancamentoControllerOpenApi {
	
	@ApiOperation("Estatistica de lançamentos por apartamentos")
	public List<ControleLancamentoResponseDTO> porApartamento(LancamentoControleFilter filtro);
	
	@ApiOperation("Busca todos lançamentos paginados")
	public Page<ControleLancamento> pesquisar(ControleFilter controleFilter, Pageable pageable);
	
	@ApiOperation("Busca todos lançamentos sem paginação")
	public List<ControleLancamentoResponseDTO> listar();
	
	@ApiOperation("Cria um novo lançamento")
	@ApiResponses({
        @ApiResponse(code = 201, message = "Lançamento cadastrado"),
    })
	public ControleLancamentoResponseDTO criar(
			@ApiParam(name = "corpo", value = "Representação de um lançamento") ControleLancamentoPostDTO controleLancamentoPostDTO, HttpServletResponse response);
	
	@ApiOperation("Deleta um lançamento por id")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Lançamento excluido", response = Problema.class),
		@ApiResponse(code = 404, message = "Lançamento não encontrado", response = Problema.class)		
	})
	public void remover(@ApiParam(value = "ID de lançamento", example = "1") Long id);
	
	@ApiOperation("Atualiza lançamento por id")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "ID de lançamento inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Lançamento não encontrado", response = Problema.class),	 
	 })
	public ControleLancamentoResponseDTO atualizar(
			@ApiParam(value = "ID de um lançamento", example = "1") Long id,  
			@ApiParam(name = "corpo", value = "Representação de um lançamento")
			ControleLancamentoPutDTO controleLancamento);
	
	@ApiOperation("Atualiza lançamento por status")
	 @ApiResponses({
		 @ApiResponse(code = 400, message = "Status de lançamento inválido", response = Problema.class),
		 @ApiResponse(code = 404, message = "Lançamento não encontrado", response = Problema.class),	 
	 })
	public void atualizarStatus(@PathVariable Long id);
	
	@ApiOperation("Busca por id")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Lançamento não encontrado", response = Problema.class)		
	})
	public ControleLancamentoResponseDTO buscarPeloId(@ApiParam(value = "ID de um lançamento", example = "1") Long id);
	
	@ApiOperation("Relatório de Lançamentos PDF")
	@ApiResponses({
		@ApiResponse(code = 404, message = "Lançamento não encontrado", response = Problema.class)		
	})
	public ResponseEntity<byte[]> relatorioPorLancamentoControlePdf(LancamentoControleFilter filtro) throws JRException;
}
