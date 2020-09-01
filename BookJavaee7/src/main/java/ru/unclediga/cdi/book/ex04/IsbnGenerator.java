package ru.unclediga.cdi.book.ex04;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

public class IsbnGenerator implements NumberGenerator {
  private static Logger logger = Logger.getLogger(IsbnGenerator.class.getName());
  public String generateNumber() {
    String isbn = "13-84356-" + Math.abs(new Random().nextInt());
    logger.info("Generated ISBN : " + isbn);
    return isbn;
  }
}