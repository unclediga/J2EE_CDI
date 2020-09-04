package ru.unclediga.cdi.book.db;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        final DerbyPingService derbyPingService = container.instance().select(DerbyPingService.class).get();
        try {
            derbyPingService.ping();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
