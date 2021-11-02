package ru.unclediga.cdi.book.ex04;

import ru.unclediga.cdi.book.Book;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

public class NumberGeneratorTest {
    
    private static Weld weld;
    private static WeldContainer container;

    @BeforeClass
    public static void init(){
        weld = new Weld();
        weld.disableDiscovery()
            .packages(BookService.class);
 
        container = weld.initialize();
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }
          
    @Test
    public void Test1(){
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println(book);
        assertTrue(book.getNumber().startsWith("13-84356"));
   }
}
