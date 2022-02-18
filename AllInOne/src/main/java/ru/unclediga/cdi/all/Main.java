package ru.unclediga.cdi.all;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main{
	public static void main(String[] args) {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.select(BookService.class).get();
		Book book = bookService.createBook("The Hitchhiker's Guide to the Galaxy", 100.0F, "by Douglas Adams 1978");
		System.out.println(book);

		System.out.println("Query " + bookService.execQuery());

		weld.shutdown();

	}
}