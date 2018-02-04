package onl.jon;

import lombok.Getter;

@Getter
class EchoMessage {

    private final long timestamp;
    private final String echoText;

    EchoMessage(String echoText) {
        this.timestamp = System.currentTimeMillis();
        this.echoText = echoText;
    }
}
