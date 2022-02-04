package ru.unclediga.cdi.book.ex25_2;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundConstruct;
import javax.interceptor.InvocationContext;

import java.util.logging.Logger;

public class LoggingInterceptor{

	@Inject
	private Logger logger;

	@AroundConstruct
	private void init(InvocationContext ic) {

	    logger.severe("OUTER >>> @AroundConstruct >>>");
    	//logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
    	try{
    		ic.proceed();
    	}catch (Exception e) {
    		System.out.print(e.getMessage());
    	}finally{
    	  logger.severe("OUTER <<< @AroundConstruct <<<");
    	  //logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
    	}
	}

	@AroundInvoke
	private Object logMethod(InvocationContext ic) throws Exception {
		logger.severe("OUTER >>> @AroundInvoke >>>");
    	logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
    	logger.severe(">>>" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    	try{
    		return ic.proceed();
    	}finally{
    	  logger.severe("OUTER <<< @AroundInvoke <<<");
	      logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
	      logger.severe("<<<" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    	}
	}
}

