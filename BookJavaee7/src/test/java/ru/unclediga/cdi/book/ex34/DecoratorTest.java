package ru.unclediga.cdi.book.ex34;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

import ru.unclediga.cdi.book.Book;

public class DecoratorTest{
    private static Weld weld;
    private static WeldContainer container;
    private Logger logger = Logger.getLogger(DecoratorTest.class.getName());

    @BeforeClass
    public static void init(){
        weld = new Weld();


        weld.disableDiscovery()
                        .packages(BookService.class)
                        .beanClasses(ru.unclediga.cdi.book.Book.class, ru.unclediga.cdi.book.LoggerProducer.class)
                        .decorators(FromEightToThirteenDigitsDecorator.class);
 

/*
        weld.disableDiscovery()
                        .packages(CustomerService.class)
                        .beanClasses(ru.unclediga.cdi.book.LoggerProducer.class)
                        .interceptors(LoggingInterceptor.class, SecondLoggingInterceptor.class);
*/

        container = weld.initialize();
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }

    @Test
    public void decoratorTest(){
        BookService service = container.instance().select(BookService.class).get();
        Book book = service.createBook("Core Java",100f,"Java tutorial");
        assertTrue(book.getNumber().startsWith("13-"));
        logger.info("Book is " + book);
    }
}