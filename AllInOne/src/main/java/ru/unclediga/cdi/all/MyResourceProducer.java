package ru.unclediga.cdi.all;


import javax.inject.Inject;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Disposes;

import java.util.logging.Logger;

public class MyResourceProducer {
	@Inject 
	private static MyServer server;

	@Inject
	private Logger logger;

	@Produces
	public MyServer getServer(){
	  	return new MyServer("Test Server");
	}

	@Produces
	public MyConnection getConnection(MyServer server){
        logger.info("getConnection() fired"); 
		return server.getConnection();
	}

	@Produces
	public MySession getSession(MyConnection connection){
        logger.info("getSession() fired"); 
		return connection.getSession();
	}


    public void closeServer(@Disposes MyServer server){
	 	server.close();
	}

	public void closeConnection(@Disposes MyConnection connection){
        logger.info("connection.close() fired"); 
		connection.close();
	}

	public void closeSession(@Disposes MySession session){
		logger.info("session.close() fired");
		session.close();
	}
}