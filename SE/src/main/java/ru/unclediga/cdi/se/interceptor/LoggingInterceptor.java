package ru.unclediga.cdi.se.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptor;

import java.util.logging.Logger;

import javax.annotation.Priority;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.APPLICATION+50)
public class LoggingInterceptor{

	private Logger logger = Logger.getLogger(LoggingInterceptor.class.getName());

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.info("v v v v v v v v v ENTER LoggingInterceptor");
		logger.info(" Class " + ctx.getTarget().getClass().getName());
		logger.info(" Method " + ctx.getMethod().getName());
		try{
			return ctx.proceed();
		}finally{
	            logger.info("^ ^ ^ ^ ^ ^ ^ ^ ^ EXIT LoggingInterceptor");
		}
	}
}