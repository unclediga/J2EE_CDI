package ru.unclediga.cdi.book.ex25_2;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

public class InterceptorTest{
    private static Weld weld;
    private static WeldContainer container;
    private Logger logger = Logger.getLogger(InterceptorTest.class.getName());

    @BeforeClass
    public static void init(){
        weld = new Weld();
        weld.disableDiscovery().packages(CustomerService.class,ru.unclediga.cdi.book.LoggerProducer.class);
        container = weld.initialize();
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }

    @Test
    public void InvokeAroundTest(){
        CustomerService service = container.instance().select(CustomerService.class).get();
        logger.info("BEFORE Construct Customer");
        Customer c = new Customer("Ivanov","Ivan","a@mail.ru");
        logger.info("BEFORE Create Customer");
        service.createCustomer(c);
        logger.info("BEFORE find Customer");
        service.findCustomer(new Customer("Petrov","Peter","b@mail.ru"));
        logger.info("BEFORE update Customer");
        service.updateCustomer(new Customer("Petrov","Peter","b@mail.ru"));
    }
}