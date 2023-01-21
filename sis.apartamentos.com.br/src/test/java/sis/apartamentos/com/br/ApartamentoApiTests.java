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
import sis.apartamentos.com.br.util.TokenUtil;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/application.properties")
public class ApartamentoApiTests {

    private final String VALOR_PATH = "/apartamentosapi/v1/valores";

    @LocalServerPort
    private int PORT = 8089;

    @Test
    void deveSalvarValor() throws IOException {
        RestAssured.given()
                .header("Authorization","Bearer "+TokenUtil.getToken())
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
