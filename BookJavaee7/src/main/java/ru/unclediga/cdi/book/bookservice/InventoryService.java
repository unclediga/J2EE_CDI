package ru.unclediga.cdi.book.bookservice;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InventoryService {
    @Inject
    private Logger logger;
    private static List<Book> inventory = new ArrayList<>();

    public void addBook(@Observes Book book) {
        logger.info("Fired new book event");
        inventory.add(book);
        logger.info("inventory has " + inventory.size() + " book(s)");
        logger.info("Last book is "
                + (inventory.size() != 0 ? inventory.get(inventory.size() - 1) : "NULL"));
    }
}
