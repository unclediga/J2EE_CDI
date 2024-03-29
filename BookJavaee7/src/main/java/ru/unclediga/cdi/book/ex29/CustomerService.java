package ru.unclediga.cdi.book.ex29;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.interceptor.ExcludeClassInterceptors;
import javax.annotation.PostConstruct;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Loggable
public class CustomerService{
  @Inject 
  private Logger logger;

  public void init(){
     logger.info("init() for CustomerService // @PostConstruct");
  }

  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
    logger.info("PATH " + this.getClass().getClassLoader().getSystemResource("."));
  }

  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
    logger.info("PATH " + this.getClass().getClassLoader().getSystemResource("."));
  }

  public void updateCustomer(Customer customer) {
    logger.info("UPDATING Customer" + customer);
    logger.info("PATH " + this.getClass().getClassLoader().getSystemResource("."));
  }

  public void removeCustomer(Customer customer) {
    logger.info("REMOVING Customer" + customer);
    logger.info("PATH " + this.getClass().getClassLoader().getSystemResource("."));
  }
}
