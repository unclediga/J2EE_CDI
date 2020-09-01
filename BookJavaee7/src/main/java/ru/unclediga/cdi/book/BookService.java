package ru.unclediga.cdi.book;

import javax.inject.Inject;

public class BookService {
  @Inject
  private NumberGenerator numberGenerator;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }
}
