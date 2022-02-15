package ru.unclediga.cdi.book.ex36;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

import ru.unclediga.cdi.book.Book;

public class EventTest{
    private static Weld weld;
    private static WeldContainer container;
    private Logger logger = Logger.getLogger(EventTest.class.getName());

    @Inject
    InventoryService srv;

    @BeforeClass
    public static void init(){
        weld = new Weld();


        weld.disableDiscovery()
                        .packages(BookService.class)
                        .beanClasses(ru.unclediga.cdi.book.Book.class, ru.unclediga.cdi.book.LoggerProducer.class);
 

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
    public void eventTest(){
        BookService service = container.instance().select(BookService.class).get();
        Book book = service.createBook("Core Java",100f,"Java tutorial");
        logger.info("storeSize = " + srv.storeSize());
        service.deleteBook(book);
    }
}