package ru.unclediga.cdi.book.bookservice;

import javax.inject.Inject;
import java.util.logging.Logger;


@ThirteenDigits
@Even
public class IsbnGenerator implements NumberGenerator {
    @Inject
    private Logger logger;

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