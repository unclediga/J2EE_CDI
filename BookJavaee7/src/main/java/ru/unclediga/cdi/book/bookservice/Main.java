package ru.unclediga.cdi.book.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book1 = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        Book book2 = bookService.createBook("War And Peace", 70.0f, "Russian classic");
        bookService.removeBook(book1);
        bookService.removeBook(book2);
        weld.shutdown();
    }
}
