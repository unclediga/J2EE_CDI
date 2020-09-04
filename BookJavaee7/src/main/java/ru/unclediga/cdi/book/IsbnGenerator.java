package ru.unclediga.cdi.book;

import javax.inject.Inject;
import java.util.logging.Logger;


@ThirteenDigits
@Even
public class IsbnGenerator implements NumberGenerator {
    private static Logger logger = Logger.getLogger(IsbnGenerator.class.getName());
    @Inject
    @ThirteenDigits
    private String prefix;

    @Inject
    @ThirteenDigits
    private int editorNumber;

    @Inject
    @MyRandom
    private double postFix;

    public String generateNumber() {
        String isbn = prefix + editorNumber + postFix;
        logger.info("Generated ISBN : " + isbn);
        return isbn;
    }
}