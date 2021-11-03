package ru.unclediga.cdi.book.ex16_2;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import java.util.Random;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

public class NumberProducer {
    @Inject
    private Logger logger;

    @Produces
    @ThirteenDigits
    private String prefix13digits = "13";

    @Produces
    private int editorNumber = 84356;

    @Produces
    @EightDigits
    private String prefix8digits = "8";

    @Produces
    @Default
    public double random13() {
        double res =  Math.abs(new Random().nextInt());
        logger.info("random13 (rnd) = " + String.format("%5.0f", res));  
        res = res * 100 + 13;
        logger.info("random13 (+13)= " + String.format("%5.0f", res));  
        return res;  
   }

    @Produces
    @MyRandom
    public double random8() {
        double res =  Math.abs(new Random().nextInt());
        logger.info("random8 (rnd) = " + String.format("%5.0f", res));  
        res = res * 100 + 8;
        logger.info("random8 (+8)= " + String.format("%5.0f", res));  
        logger.info("Math.abs(new Random().nextDouble())= " + (Math.abs(new Random().nextDouble()) * 100 + 8));  
        return res;
    }
}