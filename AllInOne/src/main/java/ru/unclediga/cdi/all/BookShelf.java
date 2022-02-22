package ru.unclediga.cdi.all;

import javax.inject.Inject;

import javax.enterprise.event.Observes;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class BookShelf {

  @Inject 
  Logger logger;

  private static List<Book> shelf  = new ArrayList<>();
  
  public void putBook(@Observes @PutBook Book book){
    shelf.add(book);
    logger.info("SHELF: put [" + book.getTitle() + "]");
  }

  public void takeBook(@Observes @TakeBook Book book){
    shelf.remove(book);
    logger.info("SHELF: take [" + book.getTitle() + "]");
    logger.info("SHELF: numbers of books : [" + shelf.size() + "]");
 }
  
}