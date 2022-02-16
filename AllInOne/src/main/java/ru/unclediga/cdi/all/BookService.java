package ru.unclediga.cdi.all;

import javax.inject.Inject;

public class BookService {
  
  @Inject
  @ThirteenDigits
  NumberGenerator numberGenerator;

  @Loggable
  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }
}
