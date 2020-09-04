package ru.unclediga.cdi.book.bookservice;

import javax.enterprise.inject.Produces;
import java.util.Random;

public class NumberProducer {
    @Produces
    @ThirteenDigits
    private String prefix13digits = "13-";
    @Produces
    @ThirteenDigits
    private int editorNumber = 84356;
    @Produces
    @EightDigits
    private String prefix8digits = "8-";

    @Produces
    @MyRandom
    public double random() {
        return Math.abs(new Random().nextInt());
    }
}
