package ru.unclediga.cdi.book.db;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class DerbyPingService {
    @Inject
    private Connection conn;

    public void ping() throws SQLException {
        final ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
        while (resultSet.next()){
            System.out.println("return = "+resultSet.getInt(1));
        }
    }
}
