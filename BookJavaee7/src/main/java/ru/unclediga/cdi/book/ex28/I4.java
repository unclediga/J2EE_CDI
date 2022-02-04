package ru.unclediga.cdi.book.ex28;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class I4 {

  @Inject
  private Logger logger;

  @AroundInvoke
  public Object logMethod(InvocationContext ic) throws Exception {
    logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
    logger.severe("I4>>>" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
    try {
      return ic.proceed();
    } finally {
      logger.severe("I4<<<" + ic.getTarget().toString() + " - " + ic.getMethod().getName());
      logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
    }
  }
}
