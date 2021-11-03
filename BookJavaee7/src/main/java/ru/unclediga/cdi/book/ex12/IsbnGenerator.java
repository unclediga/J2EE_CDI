package ru.unclediga.cdi.book.ex12;

import javax.enterprise.inject.Default;
import java.util.Random;
import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@ThirteenDigits 
@Odd
public class IsbnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(IsbnGenerator.class.getName());
  public String generateNumber() {
    String isbn = "13-84356-" + Math.abs(new Random().nextInt());
    logger.info("Generated ISBN : " + isbn);
    return isbn;
  }
}