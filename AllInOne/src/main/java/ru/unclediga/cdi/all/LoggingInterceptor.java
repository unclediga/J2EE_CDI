package ru.unclediga.cdi.all;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptor;

import javax.inject.Inject;

import java.util.logging.Logger;


@Interceptor
@Loggable
public class LoggingInterceptor {

	@Inject 
	Logger logger;

	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception{
		logger.severe(">>> INTERCEPT");
		logger.severe(">>> " + ctx.getMethod().getDeclaringClass().getSimpleName() + "." + ctx.getMethod().getName() + "()");
		logger.info("Simple name "+ ctx.getMethod().getDeclaringClass().getSimpleName());
		Object res = ctx.proceed();
		logger.severe("<<< " + ctx.getMethod().getDeclaringClass().getSimpleName() + "." + ctx.getMethod().getName() + "()");
		logger.severe("<<< INTERCEPT");
		return res;
	}
	
}