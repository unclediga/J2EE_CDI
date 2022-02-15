package ru.unclediga.cdi.book.ex36;

import javax.inject.Inject;

import javax.enterprise.event.Event;

import ru.unclediga.cdi.book.*;

public class BookService {

  @Inject
  private NumberGenerator numberGenerator;
  
  @Inject
  @Added
  private Event<Book> bookAddedEvent;

  @Inject
  @Removed
  private Event<Book> bookRemovedEvent;

  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setNumber(numberGenerator.generateNumber());
    bookAddedEvent.fire(book);
    return book;
  }

  public void deleteBook(Book book){
    bookRemovedEvent.fire(book);

  }
}
