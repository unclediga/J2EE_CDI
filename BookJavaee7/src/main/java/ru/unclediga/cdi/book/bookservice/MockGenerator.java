package ru.unclediga.cdi.book.bookservice;

import javax.enterprise.inject.Alternative;

@Alternative
@EightDigits  /* if not defined == @Default*/
public class MockGenerator implements NumberGenerator {
    public String generateNumber() {
        return "Mock";
    }
}
