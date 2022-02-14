package ru.unclediga.cdi.book.ex29;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptor;

import java.util.logging.Logger;

import javax.annotation.Priority;

@Interceptor
@Loggable
@Priority(Interceptor.Priority.PLATFORM_BEFORE)
public class SecondLoggingInterceptor{

	private Logger logger = Logger.getLogger(SecondLoggingInterceptor.class.getName());

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.info("v v v v v v v v v 222 ENTER 222 LoggingInterceptor");
		logger.info(" Class " + ctx.getTarget().getClass().getName());
		logger.info(" Method " + ctx.getMethod().getName());
		try{
			return ctx.proceed();
		}finally{
	            logger.info("^ ^ ^ ^ ^ ^ ^ ^ ^ 222 EXIT 222 LoggingInterceptor");
		}
	}
}