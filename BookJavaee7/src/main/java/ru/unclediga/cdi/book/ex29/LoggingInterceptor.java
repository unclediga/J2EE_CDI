package ru.unclediga.cdi.book.ex29;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptor;

import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor{

	@Inject
	private Logger logger;

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		logger.info("ENTER LoggingInterceptor");
		try{
			return ctx.proceed();
		}finally{
	            logger.info("EXIT LoggingInterceptor");
		}
	}
}