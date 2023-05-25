package sis.apartamentos.com.br.api.v1.icontroller;

import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioFilterDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioPostDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioResponseDTO;
import sis.apartamentos.com.br.domain.model.Diario;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "Diario")
public interface DiarioControllerOpenApi {

    @ApiOperation("Busca todos diarios paginados")
    Page<Diario> pesquisar(DiarioFilterDTO diarioFilterDTO, Pageable pageable);

    @ApiOperation("Cria um novo diario")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Diario cadastrado"),
    })
    DiarioResponseDTO criar(@ApiParam(name = "corpo", value = "Representação de um diario") DiarioPostDTO diarioPostDTO, HttpServletResponse response);
}
