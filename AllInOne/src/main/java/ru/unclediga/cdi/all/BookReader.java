package ru.unclediga.cdi.all;

import javax.enterprise.event.Event;

import javax.inject.Inject;

import java.util.logging.Logger;

public class BookReader {

  @Inject 
  Logger logger;

  @PutBook
  @Inject
  Event<Book> putEvent;

  @TakeBook
  @Inject
  Event<Book> takeEvent;

  public void putBook(Book book){
    logger.info("Reader put book on shelf: " + book.getTitle());
    putEvent.fire(book);
  }

  public void takeBook(Book book){
    logger.info("Reader take book from shelf: " + book.getTitle());
    takeEvent.fire(book);
  }
  
}