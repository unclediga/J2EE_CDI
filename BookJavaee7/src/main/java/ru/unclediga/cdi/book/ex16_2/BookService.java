package ru.unclediga.cdi.book.ex16_2;

import javax.inject.Inject;

import ru.unclediga.cdi.book.*;

public class BookService {

  @Inject
  private NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }

}
