package ru.unclediga.cdi.book.ex10;

import javax.inject.Qualifier;
import java.util.Random;

import ru.unclediga.cdi.book.*;

@NumberOfDigits(odd = false, value = Digits.EIGHT)
public class IssnGenerator implements NumberGenerator {
    public String generateNumber() {
        return "8-" + Math.abs(new Random().nextInt());
    }
}
