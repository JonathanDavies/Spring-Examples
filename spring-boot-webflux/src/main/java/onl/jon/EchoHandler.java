package onl.jon;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class EchoHandler {

    private final EchoMessageCreator echoer;

    public EchoHandler(EchoMessageCreator echoer) {
        this.echoer = echoer;
    }

    public Mono<ServerResponse> echo(ServerRequest request) {
        Mono<String> body = request.bodyToMono(String.class);

        String content = body.block();
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(echoer.createEchoMessage(content.toUpperCase())));
    }
}
