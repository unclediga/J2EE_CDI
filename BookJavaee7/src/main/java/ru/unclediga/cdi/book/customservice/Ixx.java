package ru.unclediga.cdi.book.customservice;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class Ixx {
    @Inject
    Logger logger;

    public Object logMethod(InvocationContext context, String name) throws Exception {
        logger.severe(name + " entering " + context.getMethod().getName() + "()");
        try {
            return context.proceed();
        } finally {
            logger.severe(name + " exiting " + context.getMethod().getName() + "()");
        }
    }
}
