package ru.unclediga.cdi.book.ex36;

import javax.inject.Inject;

import javax.enterprise.event.Observes;

import ru.unclediga.cdi.book.*;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class InventoryService {

	@Inject Logger logger;

	private List<Book> store = new ArrayList<>(); 

	public void addBook(@Observes @Added Book book){
		store.add(book);
		logger.info("Adding book " + book.getTitle() + " to our Inventory");

	}

	public void removeBook(@Observes @Removed Book book){
		store.remove(book);
		logger.info("Removing book " + book.getTitle() + " from our Inventory");
	}

	public int storeSize(){
		return store.size();
	}
}

