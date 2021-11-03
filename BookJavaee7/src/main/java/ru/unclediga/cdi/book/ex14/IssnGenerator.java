package ru.unclediga.cdi.book.ex14;

import javax.inject.Qualifier;
import java.util.Random;

import ru.unclediga.cdi.book.*;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
}
