package ru.unclediga.cdi.book.ex19;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DerbyPingService implements PingService{

    @Inject
    @DBType("DERBY")
    private Connection conn;
    private Logger logger = Logger.getLogger("DerbyPingService");

    @Override
    public boolean ping() {
        logger.info("pinging connection Derby...");
        try{
            conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
        }catch(SQLException e){
            return false;
        }
        return true;
    }
}
