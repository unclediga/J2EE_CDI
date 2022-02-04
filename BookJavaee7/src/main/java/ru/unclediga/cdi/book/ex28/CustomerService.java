package ru.unclediga.cdi.book.ex28;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.interceptor.ExcludeClassInterceptors;
import javax.annotation.PostConstruct;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Interceptors({I1.class,I2.class})
public class CustomerService{
  @Inject 
  private Logger logger;

  @PostConstruct
  public void init(){
     logger.info("init() for CustomerService // @PostConstruct");
  }

  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
  }
  @Interceptors({I3.class,I4.class})
  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }

  @ExcludeClassInterceptors 
  public void updateCustomer(Customer customer) {
    logger.info("UPDATING Customer" + customer);
  }

  public void removeCustomer(Customer customer) {
    logger.info("REMOVING Customer" + customer);
  }
}
