package ru.unclediga.cdi.all;

import javax.inject.Inject;
import javax.decorator.Decorator;
import javax.decorator.Delegate;

import java.util.logging.Logger;

@Decorator
class FromEightToThirteenDigitsDecoratorPostfix implements NumberGenerator {

  @Inject
  @EightDigits
  @Delegate
  private NumberGenerator numberGenerator;

  @Inject 
  Logger logger;

  public String generateNumber(){
    String issn = numberGenerator.generateNumber();
    String isbn = issn.substring(0,issn.length() - 3) + "-13";
    logger.info("Decorator get ISSN-number " + issn);
    logger.info("... and convert to ISBN-number " + isbn);
    return isbn;
  }
}