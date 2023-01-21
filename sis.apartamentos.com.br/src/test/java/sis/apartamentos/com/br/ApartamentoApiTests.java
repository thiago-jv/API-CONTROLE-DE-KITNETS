package sis.apartamentos.com.br;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sis.apartamentos.com.br.util.FileUtils;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/application.properties")
public class ApartamentoApiTests {

    private final String VALOR_PATH = "/apartamentosapi/v1/valores";

    private final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NzQzMTY1MjQsInVzZXJfbmFtZSI6InRoaWFnb0Bob3RtYWlsLmNvbSIsImF1dGhvcml0aWVzIjpbIlJPTEVfUEVTUVVJU0FSX0lOUVVJTElOTyIsIlJPTEVfQ0FEQVNUUkFSX0lOUVVJTElOTyIsIlJPTEVfUEVTUVVJU0FSX0FQQVJUQU1FTlRPIiwiUk9MRV9QRVNRVUlTQVJfUFJFRElPIiwiUk9MRV9SRU1PVkVSX0lOUVVJTElOTyIsIlJPTEVfQ0FEQVNUUkFSX0FQQVJUQU1FTlRPIiwiUk9MRV9QRVNRVUlTQVJfTEFOQ0FNRU5UTyIsIlJPTEVfUkVNT1ZFUl9BUEFSVEFNRU5UTyIsIlJPTEVfQ0FEQVNUUkFSX1ZBTE9SIiwiUk9MRV9DQURBU1RSQVJfTEFOQ0FNRU5UTyIsIlJPTEVfUkVNT1ZFUl9QUkVESU8iLCJST0xFX1BFU1FVSVNBUl9WQUxPUiIsIlJPTEVfUkVNT1ZFUl9MQU5DQU1FTlRPIiwiUk9MRV9DQURBU1RSQVJfUFJFRElPIiwiUk9MRV9SRU1PVkVSX1ZBTE9SIl0sImp0aSI6ImtQd2RpbFc1S3RtbXNpNl9keDVWUzdmQ09VWSIsImNsaWVudF9pZCI6ImFuZ3VsYXIiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.ZvP7f8qe0iWlyA3Jp9vPxJUxAWfX0UJVOVLOTPOBbG8";

    @LocalServerPort
    private int PORT = 8089;

    @Test
    void deveSalvarValor() throws IOException {
        RestAssured.given()
                .header("Authorization","Bearer "+TOKEN)
                .basePath(VALOR_PATH)
                .port(PORT)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(FileUtils.readFileContent("valor_post.json"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

}
