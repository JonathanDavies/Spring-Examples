package onl.jon;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/echo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_JSON)
public class EchoResource {

    private final EchoMessageCreator echoer;

    public EchoResource(EchoMessageCreator echoer) {
        this.echoer = echoer;
    }

    @POST
    public EchoMessage echo(String echoText) {
        return echoer.createEchoMessage(echoText);
    }
}
