package ru.unclediga.cdi.book.ex16_2;

import ru.unclediga.cdi.book.*;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import java.util.logging.Logger;


public class NumberGeneratorTest {
    
    private static Weld weld;
    private static WeldContainer container;
    @Inject
    private Logger logger;

    @BeforeClass
    public static void init(){
        weld = new Weld();
        weld.disableDiscovery().packages(BookService.class,NumberGeneratorTest.class);

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
        assertTrue("13 Digit ISBN must start with 13-84356-", book.getNumber().startsWith("13-84356-"));
        assertTrue("13 Digit ISBN must ends with 13", book.getNumber().endsWith("13"));
   }

    @Test
    public void Test8DigitsNumber(){
        LegacyBookService bookService = container.instance().select(LegacyBookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println("ISSN="+book.getNumber());
        assertTrue("8 Digit ISBN must start with 8-", book.getNumber().startsWith("8-"));
        assertTrue("8 Digit ISSN must ends with 08", book.getNumber().endsWith("08"));
   }

    @Test
    public void TestLogger(){
        /*java.lang.NullPointerException: null
        at ru.unclediga.cdi.book.ex16_2.NumberGeneratorTest.TestLogger(NumberGeneratorTest.java:59)
         */ 
        //logger.info("<<< info from injected logger >>>"); 
       
   }
}
