package ru.unclediga.cdi.book.ex19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

public class JDBCConnectionProducer {

    private static Logger logger = Logger.getLogger("JDBCConnectionProducer");
    
    @Produces
    @DBType("HSQL")
    private Connection createHsqlConnection(){
        logger.info("create connection for HSQL...");
        Connection conn = null;
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sys", "");
            logger.info("Connection for HSQL created!");
        } catch(ClassNotFoundException | SQLException e){
            logger.warning("Exception while HSQL connection creating!");
            e.printStackTrace();
        }
        return conn;
    }

    
    private void closeHsqlConnection(@Disposes @DBType("HSQL") Connection conn) throws SQLException{
        logger.info("close connection HSQL");
        conn.close();
    }


    @Produces
    @DBType("DERBY")
    private Connection createDerbyConnection(){
        logger.info("create connection for Derby");
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection("jdbc:derby:memory:chapter02DB;create=true", "APP", "APP");
            logger.info("Connection for Derby created!");
        } catch(ClassNotFoundException | SQLException e){
            logger.warning("Exception while Derby connection creating!");
            e.printStackTrace();
        }
        return conn;
    }
    
    private void closeDerbyConnection(@Disposes @DBType("DERBY") Connection conn) throws SQLException{
        logger.info("close connection DERBY");
        conn.close();
    }
}
