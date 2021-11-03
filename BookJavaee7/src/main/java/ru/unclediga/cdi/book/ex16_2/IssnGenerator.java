package ru.unclediga.cdi.book.ex16_2;

import java.util.logging.Logger;
import javax.inject.Inject;
import java.util.Random;

import ru.unclediga.cdi.book.*;

@EightDigits
public class IssnGenerator implements NumberGenerator {
  @Inject
  private Logger logger;

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
