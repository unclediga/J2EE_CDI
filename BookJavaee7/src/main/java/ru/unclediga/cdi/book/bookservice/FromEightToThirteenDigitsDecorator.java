package ru.unclediga.cdi.book.bookservice;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator {
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
        return prefix13digits + editorNumber + issn.substring(1);
    }
}
