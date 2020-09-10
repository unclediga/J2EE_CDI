package ru.unclediga.cdi.book.bookservice;

import javax.inject.Inject;
import java.util.logging.Logger;

@EightDigits
public class IssnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

    @Inject
    @EightDigits
    private String prefix;

    @Inject
    @MyRandom
    private double postFix;

    public String generateNumber() {
        final String issn = prefix + postFix;
        logger.info("Generated ISSN : " + issn);
        return issn;
    }
}
