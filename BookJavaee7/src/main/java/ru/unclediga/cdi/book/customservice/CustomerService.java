package ru.unclediga.cdi.book.customservice;

import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Interceptors(LoggingInterceptor.class)
public class CustomerService {
//    @Inject
//    private EntityManager em;
    @Inject
    private Logger logger;

    public void createCustomer(Customer customer) {
        logger.entering(getClass().getName(),"create");
        logger.info("i create");
//        em.persist(customer);
    }

    public Customer findCustomerById(Long id) {
        logger.info("i findCustomerById");
        //        return em.find(Customer23.class, id);
        return null;
    }

    @ExcludeClassInterceptors
    public Customer updateCustomer(Customer customer) {
        logger.info("i updateCustomer");
        //        return em.find(Customer23.class, id);
        return null;
    }
}
