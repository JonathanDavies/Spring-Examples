package onl.jon;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.ws.rs.ApplicationPath;

@Configuration
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public EchoMessageCreator echoMessageCreator() {
        return new EchoMessageCreator(context());
    }

    @Bean
    @RequestScope
    public Context context() {
        return new Context();
    }

    @Component
    @ApplicationPath("/service")
    public static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            packages(getClass().getPackage().toString());
        }
    }
}
