package sis.apartamentos.com.br.api.v1.icontroller;

import io.swagger.annotations.*;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioPostDTO;
import sis.apartamentos.com.br.api.v1.dto.diario.DiarioResponseDTO;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "Diario")
public interface DiarioControllerOpenApi {

    @ApiOperation("Cria um novo diario")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Diario cadastrado"),
    })
    DiarioResponseDTO criar(@ApiParam(name = "corpo", value = "Representação de um diario") DiarioPostDTO diarioPostDTO, HttpServletResponse response);
}
