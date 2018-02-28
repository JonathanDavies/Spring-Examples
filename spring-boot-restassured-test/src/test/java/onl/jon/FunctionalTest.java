package onl.jon;

import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test_properties.yaml")
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = App.class)
public class FunctionalTest {

    @Value("${local.server.port}") private int serverPort;

    @ClassRule public static WireMockClassRule wireMockRule = new WireMockClassRule(wireMockConfig().dynamicPort());

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("wiremock.server.port", String.valueOf(wireMockRule.port()));
    }

    @Before
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    public void shouldEchoRequestBody() {

        stubFor(get(urlEqualTo("/timestamp"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"value\": 111111 }")));

        given().log().all()
                .body("jon")

                .when()
                .post("/echo")

                .then().log().all()
                .assertThat().statusCode(200)
                .assertThat().body("timestamp", equalTo(111111))
                .assertThat().body("echoText", equalTo("jon"));
    }
}
