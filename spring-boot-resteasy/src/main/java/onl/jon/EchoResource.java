package onl.jon;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/echo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class EchoResource {

    private final EchoMessageCreator echoer;
    private final Context context;

    @POST
    public EchoMessage echo(String echoText) {
        context.setText(echoText);
        return echoer.createEchoMessage();
    }
}
