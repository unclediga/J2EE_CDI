package ru.unclediga.cdi.book.ex14;

import javax.inject.Inject;
import javax.enterprise.inject.Default;

import ru.unclediga.cdi.book.*;

public class LegacyBookService {

  @Inject
  @EightDigits
  private NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }

}
