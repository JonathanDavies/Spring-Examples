package onl.jon;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class EchoMessage {

    private final String prefix;
    private final String echoText;
}
