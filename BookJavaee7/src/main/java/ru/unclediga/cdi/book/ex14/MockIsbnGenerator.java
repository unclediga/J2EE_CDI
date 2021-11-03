package ru.unclediga.cdi.book.ex14;

import javax.enterprise.inject.Alternative;
import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Alternative
public class MockIsbnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(MockIsbnGenerator.class.getName());
  public static String MOCK_NUM = "Mock-13";
    public String generateNumber() {
        logger.info("Generated MOCK ISBN - 13 digits");
        return MOCK_NUM;
    }
}



