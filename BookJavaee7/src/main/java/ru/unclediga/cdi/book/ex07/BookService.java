package ru.unclediga.cdi.book.ex07;

import javax.inject.Inject;
import javax.enterprise.inject.Default;

import ru.unclediga.cdi.book.*;

public class BookService {

  @Inject
  @ThirteenDigits
  private NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }

}
