package ru.unclediga.cdi.book.ex27;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.annotation.PostConstruct;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Interceptors(ProfileInterceptor.class)
public class CustomerService{
  @Inject 
  private Logger logger;

  @PostConstruct
  public void init(){
     logger.info("init() for CustomerService // @PostConstruct");
  }

  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
    //try {Thread.sleep(10);} catch(java.lang.InterruptedException e){};
  }

  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }
}
