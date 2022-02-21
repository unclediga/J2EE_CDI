package ru.unclediga.cdi.all;

import javax.inject.Inject;
import javax.decorator.Decorator;
import javax.decorator.Delegate;

import java.util.logging.Logger;

@Decorator
class FromEightToThirteenDigitsDecorator implements NumberGenerator {

 	@Inject
  @EightDigits
 	@Delegate
	private NumberGenerator numberGenerator;

  @Inject 
  Logger logger;

  public String generateNumber(){
    String issn = numberGenerator.generateNumber();
    String isbn = "13" + issn.substring(1);
    logger.info("Decorator get ISSN-number " + issn);
    logger.info("... and convert to ISBN-number " + isbn);
    return isbn;
  }
}