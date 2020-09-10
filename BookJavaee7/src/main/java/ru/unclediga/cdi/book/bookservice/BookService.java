package ru.unclediga.cdi.book.bookservice;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class BookService {
  @Inject
  @EightDigits
  private NumberGenerator numberGenerator;
  @Inject
  @Added
  private Event<Book> addBookEvent;
  @Inject
  @Removed
  private Event<Book> removeBookEvent;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    addBookEvent.fire(book);
    return book;
  }

  public void removeBook(Book book) {
    removeBookEvent.fire(book);
  }
}
