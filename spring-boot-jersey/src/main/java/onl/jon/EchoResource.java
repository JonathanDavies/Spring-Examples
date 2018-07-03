package onl.jon;

import javax.inject.Inject;
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
    private final Context context;

    @Inject
    public EchoResource(EchoMessageCreator echoer, Context context) {
        this.echoer = echoer;
        this.context = context;
    }

    @POST
    public EchoMessage echo(String echoText) {
        context.setText(echoText);
        return echoer.createEchoMessage();
    }
}
