package ru.unclediga.cdi.book.customservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import ru.unclediga.cdi.book.db.DerbyPingService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        final CustomerService customerService = container.instance().select(CustomerService.class).get();
        customerService.createCustomer(null);
        customerService.findCustomerById(1L);
        customerService.updateCustomer(null);
    }
}
