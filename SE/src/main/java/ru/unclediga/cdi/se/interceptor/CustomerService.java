package ru.unclediga.cdi.se.interceptor;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.interceptor.ExcludeClassInterceptors;
import javax.annotation.PostConstruct;

import java.util.logging.Logger;

import ru.unclediga.cdi.se.*;

@Loggable
public class CustomerService{

  private Logger logger = Logger.getLogger(CustomerService.class.getName());

  public void init(){
     logger.info("init() for CustomerService // @PostConstruct");
  }

  public void createCustomer(Customer customer) {
    logger.info("PATH " + this.getClass().getClassLoader().getSystemResource("."));
    logger.info("CREATE Customer" + customer);
  }

  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }

  public void updateCustomer(Customer customer) {
    logger.info("UPDATING Customer" + customer);
  }

  public void removeCustomer(Customer customer) {
    logger.info("REMOVING Customer" + customer);
  }
}
