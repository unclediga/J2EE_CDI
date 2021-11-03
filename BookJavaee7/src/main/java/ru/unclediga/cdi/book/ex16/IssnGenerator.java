package ru.unclediga.cdi.book.ex16;

import java.util.logging.Logger;
import javax.inject.Inject;
import java.util.Random;

import ru.unclediga.cdi.book.*;

@EightDigits
public class IssnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(IssnGenerator.class.getName());

  @Inject
  @EightDigits
  private String prefix;

  @Inject
  @MyRandom
  private double postfix;

  
  public String generateNumber() {
    String issn = prefix + "-" + String.format("%5.0f", postfix);
    logger.info("Generated ISSN : " + issn);
    return issn;
  }
}
