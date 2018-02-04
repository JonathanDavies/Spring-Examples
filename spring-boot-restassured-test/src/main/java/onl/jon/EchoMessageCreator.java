package onl.jon;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class EchoMessageCreator {

    private static final String TIMESTAMP_PATH = "/timestamp";
    private final WebTarget timeServiceTarget;

    public EchoMessageCreator(WebTarget timeServiceTarget) {
        this.timeServiceTarget = timeServiceTarget;
    }

    public EchoMessage createEchoMessage(String echoText) {
        return new EchoMessage(getTimestamp().getValue(), echoText);
    }

    private Timestamp getTimestamp() {
        return timeServiceTarget
                .path(TIMESTAMP_PATH)
                .request(MediaType.APPLICATION_JSON)
                .get(Timestamp.class);
    }
}
