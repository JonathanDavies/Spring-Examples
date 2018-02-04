package onl.jon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.ClientBuilder;

@Configuration
@EnableAutoConfiguration
public class App {

    @Value("${time_service_uri}")
    private String timeService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public EchoMessageCreator echoMessageCreator() {
        return new EchoMessageCreator(ClientBuilder.newClient().target(timeService));
    }

    @Bean
    public EchoController echoController() {
        return new EchoController(echoMessageCreator());
    }
}
