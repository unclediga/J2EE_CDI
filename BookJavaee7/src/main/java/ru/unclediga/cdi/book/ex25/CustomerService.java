package ru.unclediga.cdi.book.ex25;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.interceptor.ExcludeClassInterceptors;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

public class CustomerService{
  @Inject 
  private Logger logger;

//assign interceptors for the whole class + @ExcludeClassInterceptors
  @Interceptors(LoggingInterceptor.class)
  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
  }

  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }
}
