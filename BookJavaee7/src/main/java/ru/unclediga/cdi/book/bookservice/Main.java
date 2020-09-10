package ru.unclediga.cdi.book.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        book = bookService.createBook("War And Peace", 70.0f, "Russian classic");
        System.out.println(book);
        weld.shutdown();
    }
}
