package ru.unclediga.cdi.book.ex28;

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
    public void interceptorBindingTest(){
        CustomerService service = container.instance().select(CustomerService.class).get();
        Customer c = new Customer("Ivanov","Ivan","a@mail.ru");
        service.createCustomer(c);
        service.findCustomer(c);
        service.updateCustomer(c);
        service.removeCustomer(c);
    }
}