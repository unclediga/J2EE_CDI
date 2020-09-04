package ru.unclediga.cdi.book.db;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnectionProducer {
    @Inject
    Logger logger;

    @Produces
    public Connection createConnection() {
        Connection connection = null;
        logger.info("create connection in Producer");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connection = DriverManager.getConnection("jdbc:derby:memory:mydb;create=true", "APP", "APP");
        } catch (SQLException | ClassNotFoundException throwables) {
            logger.info("Exception:" + throwables.getMessage());
            throwables.printStackTrace();
        }
        return connection;
    }

    public void closeConnection(@Disposes Connection connection) throws SQLException {
        System.out.println("close connection in Disposer");
        System.out.println("logger" + logger);
        //TODO: logger don't work. Why ???
        //TODO: how to setup internal logging for Weld
        logger.info("close connection in Disposer");
        connection.close();
    }
}
