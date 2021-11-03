package ru.unclediga.cdi.book.ex14;

import javax.enterprise.inject.Alternative;
import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Alternative
@EightDigits
public class MockIssnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(MockIssnGenerator.class.getName());
  public static String MOCK_NUM = "Mock-8";

    public String generateNumber() {
        logger.info("Generated MOCK ISSN - 8 digits");
        return MOCK_NUM;
    }
}



