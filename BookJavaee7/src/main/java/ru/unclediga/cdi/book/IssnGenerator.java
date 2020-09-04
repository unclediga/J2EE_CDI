package ru.unclediga.cdi.book;

import javax.inject.Inject;
import java.util.Random;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    @EightDigits
    private String prefix;

    @Inject
    @MyRandom
    private double postFix;

    public String generateNumber() {
        return prefix + postFix;
    }
}
