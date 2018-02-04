package onl.jon;

public class EchoMessageCreator {

    public EchoMessage createEchoMessage(String echoText) {
        return new EchoMessage(echoText);
    }
}
