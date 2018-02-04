package onl.jon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

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
        return new EchoMessageCreator(context());
    }

    @Bean
    public EchoResource echoResource() {
        return new EchoResource(echoMessageCreator(), context());
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Context context() {
        return new Context();
    }

    @Component
    @ApplicationPath("/resteasy/")
    public static class JaxrsApplication extends Application {
    }
}
