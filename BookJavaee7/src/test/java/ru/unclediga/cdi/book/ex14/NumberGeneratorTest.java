package ru.unclediga.cdi.book.ex14;

import ru.unclediga.cdi.book.*;

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
        weld.disableDiscovery().packages(
                       LegacyBookService.class, BookService.class, MockIssnGenerator.class, IssnGenerator.class,
                       MockIsbnGenerator.class, IsbnGenerator.class);

        container = weld.initialize();
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }
          
    @Test
    public void Test13DigitsNumber(){
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println("ISBN="+book.getNumber());
        System.out.println("wait for ["+MockIsbnGenerator.MOCK_NUM+"]");
//        assertTrue(book.getNumber().startsWith(MockIsbnGenerator.MOCK_NUM));
   }

    @Test
    public void Test8DigitsNumber(){
        LegacyBookService bookService = container.instance().select(LegacyBookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println("ISSN="+book.getNumber());
        System.out.println("wait for ["+MockIssnGenerator.MOCK_NUM+"]");
//        assertTrue(book.getNumber().startsWith(MockIssnGenerator.MOCK_NUM));
   }
}
