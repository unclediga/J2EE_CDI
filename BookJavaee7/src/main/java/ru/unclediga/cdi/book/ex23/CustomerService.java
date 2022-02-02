package ru.unclediga.cdi.book.ex23;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

public class CustomerService{
	@Inject 
	private Logger logger;

	@AroundInvoke
	private Object innerlogMethod(InvocationContext ic) throws Exception{
		logger.severe(">>>>>>");
    	logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
    	logger.severe(">>>" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    	try{
    		return ic.proceed();
    	}finally{
    	  logger.severe("<<<<<<");
	      logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
	      logger.severe("<<<" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    	}
	}

  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
  }

  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }
}
