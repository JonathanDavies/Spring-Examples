package onl.jon;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = App.class)
public class FunctionalTest {

    @Value("${local.server.port}") private int serverPort;

    @Before
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    public void addItem() {
        String description = UUID.randomUUID().toString();

        Response response = given().log().all()
                .body(description)
                .when()
                .post("/item")
                .andReturn();

        given().log().all()
                .when()
                .get("/item/" + response.getBody().asString())
                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("description", equalTo(description));
    }

    @Test
    public void getAllItem() {
        given().log().all()
                .when()
                .get("/item")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
