package onl.jon;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

public class Context {

    private final AtomicInteger counter = new AtomicInteger();
    @Getter @Setter private String text;

    int getCount() {
        return counter.incrementAndGet();
    }
}
