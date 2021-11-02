package ru.unclediga.cdi.book.ex10;

import javax.enterprise.inject.Default;
import java.util.Random;
import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@NumberOfDigits(odd = true, value = Digits.THIRTEEN)
public class IsbnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(IsbnGenerator.class.getName());
  public String generateNumber() {
    String isbn = "13-84356-" + Math.abs(new Random().nextInt());
    logger.info("Generated ISBN : " + isbn);
    return isbn;
  }
}