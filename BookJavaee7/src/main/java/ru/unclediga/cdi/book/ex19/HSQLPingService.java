package ru.unclediga.cdi.book.ex19;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class HSQLPingService implements PingService{

    @Inject
    @DBType("HSQL")
    private Connection conn;
    private Logger logger = Logger.getLogger("HSQLPingService");

    @Override
    public boolean ping() {
        logger.info("pinging connection HSQL...");
        try{
            conn.createStatement().executeQuery("select 1 from information_schema.system_users limit 1");
        }catch(SQLException e){
            return false;
        }
        return true;
    }
}
