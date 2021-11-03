package ru.unclediga.cdi.book.ex12;

import javax.inject.Qualifier;
import java.util.Random;

import ru.unclediga.cdi.book.*;

@EightDigits
@Even
public class IssnGenerator implements NumberGenerator {
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
}
