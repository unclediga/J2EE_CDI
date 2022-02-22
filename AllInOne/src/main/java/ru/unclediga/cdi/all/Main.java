package ru.unclediga.cdi.all;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main{
	public static void main(String[] args) {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		BookService bookService = container.select(BookService.class).get();
		Book book = bookService.createBook("The Hitchhiker's Guide to the Galaxy", 100.0F, "by Douglas Adams 1978");
		//System.out.println(book);

		// System.out.println("Query " + bookService.execQuery());


		// Event test
		Book book2 = bookService.createBook("Starship Troopers", 110.0F, "by by Robert A. Heinlein 1959");
		Book book3 = bookService.createBook("1984", 120.0F, "by George Orwell 1949");

		BookReader reader = container.select(BookReader.class).get();
		reader.putBook(book);
		reader.putBook(book2);
		reader.putBook(book3);

		reader.takeBook(book3);
		reader.takeBook(book2);
		reader.takeBook(book);

		weld.shutdown();

	}
}