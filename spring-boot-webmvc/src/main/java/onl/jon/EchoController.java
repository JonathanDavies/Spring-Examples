package onl.jon;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/echo")
public class EchoController {

    private final EchoMessageCreator echoer;

    public EchoController(EchoMessageCreator echoer) {
        this.echoer = echoer;
    }

    @ResponseBody
    @RequestMapping(method = POST)
    public EchoMessage echo(@RequestBody String echoText) {
        return echoer.createEchoMessage(echoText);
    }
}
