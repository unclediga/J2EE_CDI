package ru.unclediga.cdi.book.ex10;

import javax.inject.Inject;
import javax.enterprise.inject.Default;

import ru.unclediga.cdi.book.*;

public class LegacyBookService {

  @Inject
  @NumberOfDigits(odd = false, value = Digits.EIGHT)
  private NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }

}
