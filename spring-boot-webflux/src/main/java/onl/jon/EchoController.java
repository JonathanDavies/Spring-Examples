package onl.jon;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/echo")
public class EchoController {

    private final EchoMessageCreator echoer;

    public EchoController(EchoMessageCreator echoer) {
        this.echoer = echoer;
    }

    @PostMapping
    public Mono<EchoMessage> echo(@RequestBody String echoText) {
        return Mono.just(echoer.createEchoMessage(echoText));
    }
}
