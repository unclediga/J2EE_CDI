package ru.unclediga.cdi.book.ex27;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.annotation.PostConstruct;
import javax.interceptor.InvocationContext;

import java.util.logging.Logger;

public class ProfileInterceptor{

	@Inject
	private Logger logger;

	@PostConstruct
	private void postConstrLogMethod(InvocationContext ic){
        logger.severe("Profile ex27 >>> @PostConstruct >>>");
    	try{
    		ic.proceed();
        }catch(Exception e){
           System.out.println(e.getMessage());
    	}finally{
            logger.severe("Profile ex27 <<< @PostConstruct >>>");
    	}
	}

	@AroundInvoke
    private Object profile(InvocationContext ic) throws Exception {
        logger.severe("Profile ex27 >>> @AroundInvoke >>>");
        long initTime = System.currentTimeMillis();
        try {
            return ic.proceed();
        } finally {
            logger.severe("Profile ex27 <<< @AroundInvoke >>>");
            long diffTime = System.currentTimeMillis() - initTime;
            logger.severe(" >>>>> " + ic.getMethod() + " took " + diffTime + " millis");	
        }
    }
}

