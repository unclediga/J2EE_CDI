package ru.unclediga.cdi.book.ex25_2;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptors;
import javax.interceptor.ExcludeClassInterceptors;

import java.util.logging.Logger;

import ru.unclediga.cdi.book.*;

@Interceptors(LoggingInterceptor.class)
public class CustomerService{
  @Inject 
  private Logger logger;

  public CustomerService(){
    super();
    System.out.println("Constructor. No logger yet");
  }

//assign interceptors for the whole class + @ExcludeClassInterceptors
  public void createCustomer(Customer customer) {
    logger.info("CREATE Customer" + customer);
  }

  @ExcludeClassInterceptors
  public void findCustomer(Customer customer) {
    logger.info("FINDING Customer" + customer);
  }
  
  public void updateCustomer(Customer customer) {
    logger.info("UPDATING Customer" + customer);
  }
}
