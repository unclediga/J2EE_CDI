package ru.unclediga.cdi.all;

import javax.inject.Inject;

public class BookService {
  
  @Inject
  @EightDigits
  NumberGenerator numberGenerator;

  // @Inject 
  // MySession session;

  @Loggable
  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    return book;
  }


  // public String execQuery() {
  //   return session.execQuery();
  // }
}
