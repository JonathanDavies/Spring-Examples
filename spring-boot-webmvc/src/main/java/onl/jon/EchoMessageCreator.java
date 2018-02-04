package onl.jon;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EchoMessageCreator {

    private final Context context;

    public EchoMessage createEchoMessage(String echoText) {
        return new EchoMessage(echoText);
    }

    public EchoMessage createEchoMessage() {
        return new EchoMessage(context.getCount() + " - " + context.getText());
    }
}
