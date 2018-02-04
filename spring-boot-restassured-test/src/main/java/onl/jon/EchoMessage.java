package onl.jon;

import lombok.Getter;

@Getter
class EchoMessage {

    private final long timestamp;
    private final String echoText;

    EchoMessage(long timestamp, String echoText) {
        this.timestamp = timestamp;
        this.echoText = echoText;
    }
}
