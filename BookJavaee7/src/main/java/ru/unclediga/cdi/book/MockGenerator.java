package ru.unclediga.cdi.book;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
@EightDigits  /* if not defined == @Default*/
public class MockGenerator implements NumberGenerator {
    public String generateNumber() {
        return "Mock";
    }
}
