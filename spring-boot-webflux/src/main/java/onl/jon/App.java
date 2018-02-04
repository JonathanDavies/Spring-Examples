package onl.jon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public EchoMessageCreator echoMessageCreator() {
        return new EchoMessageCreator();
    }

    @Bean
    public EchoController echoController() {
        return new EchoController(echoMessageCreator());
    }

    @Bean
    public EchoHandler echoHandler() {
        return new EchoHandler(echoMessageCreator());
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return route(POST("/echo2"), echoHandler()::echo);
    }
}
