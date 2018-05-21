package onl.jon;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.POST;

@RequiredArgsConstructor
public class EchoResource implements EchoClient {

    private final EchoMessageCreator echoer;

    @POST
    public EchoMessage echo(String echoText) {
        return echoer.createEchoMessage(echoText);
    }
}
