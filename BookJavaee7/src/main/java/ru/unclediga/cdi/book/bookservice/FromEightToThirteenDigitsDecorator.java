package ru.unclediga.cdi.book.bookservice;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.logging.Logger;

@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator {

    @Inject
    Logger logger;

    @Delegate
    @Inject
    @EightDigits
    private NumberGenerator numberGenerator;

    @Inject
    @ThirteenDigits
    private String prefix13digits;

    @Inject
    @ThirteenDigits
    private int editorNumber;

    @Override
    public String generateNumber() {
        final String issn = numberGenerator.generateNumber();
        final String isbn = prefix13digits + editorNumber + issn.substring(1);
        logger.info("Generated ISBN : " + isbn + " from ISSN :" + issn);
        return isbn;
    }
}
