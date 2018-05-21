package onl.jon;

import org.springframework.beans.factory.annotation.Value;

public class EchoMessageCreator {

    @Value("${prefix}") String prefix;

    EchoMessage createEchoMessage(String echoText) {
        return new EchoMessage(prefix, echoText);
    }
}
