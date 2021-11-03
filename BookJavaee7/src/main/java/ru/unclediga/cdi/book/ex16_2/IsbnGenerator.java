package ru.unclediga.cdi.book.ex16_2;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

public class IsbnGenerator implements NumberGenerator {
  @Inject
  private Logger logger;

  @Inject
  @ThirteenDigits
  private String prefix;

  @Inject
  private int editorNumber;

  @Inject
  private double postfix;

  
  public String generateNumber() {
    String isbn = prefix + "-"+ editorNumber + "-" + String.format("%5.0f", postfix);
    logger.info("Generated ISBN : " + isbn);
    return isbn;
  }
}