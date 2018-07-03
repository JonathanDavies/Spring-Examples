package onl.jon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

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
    public EchoResource echoResource() {
        return new EchoResource(echoMessageCreator());
    }

    @Component
    @ApplicationPath("/")
    public static class JaxrsApplication extends Application {
    }
}
