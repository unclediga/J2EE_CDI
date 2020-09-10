package ru.unclediga.cdi.book.customservice;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class ProfileInterceptor {
    @Inject
    Logger logger;

    @PostConstruct
    public void logMethod(InvocationContext invocationContext) throws Exception {
        logger.severe("PostConstruct in: " + invocationContext.getTarget().toString());
        try {
            invocationContext.proceed();
        } finally {
            logger.severe("PostConstruct out: " + invocationContext.getTarget().toString());
        }
    }

    @AroundInvoke
    public Object profile(InvocationContext invocationContext) throws Exception {
        final long initTime = System.currentTimeMillis();
        try {
            return invocationContext.proceed();
        } finally {
            final long diff = System.currentTimeMillis() - initTime;
            logger.severe("Method " + invocationContext.getMethod() + " runtime: " + diff + " ms");
        }
    }
}


