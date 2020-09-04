package ru.unclediga.cdi.book.ex06;

import javax.inject.Inject;
import javax.enterprise.inject.Default;

import ru.unclediga.cdi.book.*;

public class BookService {
  @Inject
  @Default  /* not defined == @Default*/
  private NumberGenerator numberGenerator;


  @Inject
  @EightDigits
  private NumberGenerator numberGenerator8;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }

  public Book createBook8(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator8.generateNumber());
    return book;
  }

}
