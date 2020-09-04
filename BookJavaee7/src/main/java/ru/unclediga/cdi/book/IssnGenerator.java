package ru.unclediga.cdi.book;

import javax.inject.Qualifier;
import java.util.Random;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
}
