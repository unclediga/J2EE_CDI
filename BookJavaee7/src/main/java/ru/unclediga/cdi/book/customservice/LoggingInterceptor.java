package ru.unclediga.cdi.book.customservice;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Loggable
@Interceptor  /* !!!!  required also <interceptors> in bean.xml !!!! */
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 10)
public class LoggingInterceptor {
    @Inject
    Logger logger;

    @AroundConstruct
    public void init(InvocationContext invocationContext) {
        logger.fine("Entering constructor");
        logger.severe("Entering constructor");
        try {
            invocationContext.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.fine("Exiting constructor");
        logger.severe("Exiting constructor");
    }

    @AroundInvoke
    public Object logMethod(InvocationContext invocationContext) throws Exception {
        logger.entering(invocationContext.getTarget().toString(),
                invocationContext.getMethod().getName() + "()");
        logger.severe(invocationContext.getTarget().toString() + " >> " +
                invocationContext.getMethod().getName() + "()");
        try {
            return invocationContext.proceed();
        } finally {
            logger.exiting(invocationContext.getTarget().toString(),
                    invocationContext.getMethod().getName() + "()");
            logger.severe(invocationContext.getTarget().toString() + " >> " +
                    invocationContext.getMethod().getName() + "()");
        }
    }
}
