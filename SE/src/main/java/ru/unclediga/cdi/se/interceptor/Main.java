package ru.unclediga.cdi.se.interceptor;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class Main{
    private static Weld weld;
    private static WeldContainer container;
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args){
        logger.info("ENTER Main");

        weld = new Weld();
        //weld.disableDiscovery().packages(CustomerService.class);
        container = weld.initialize();
        CustomerService service = container.instance().select(CustomerService.class).get();
        Customer c = new Customer("Ivanov","Ivan","a@mail.ru");
        service.createCustomer(c);
        c.setLastName("PETROV"); 
        service.createCustomer(c);
        service.findCustomer(c);
//        service.updateCustomer(c);
//        service.removeCustomer(c);

        weld.shutdown();   

        logger.info("EXIT Main");
    }
}