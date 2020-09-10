package ru.unclediga.cdi.book.customservice;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import java.util.logging.Logger;

public class CustomerService {
//    @Inject
//    private EntityManager em;
    @Inject
    private Logger logger;

    @PostConstruct
    public void init(){
        logger.info("invoke init()...");
        sleeper();
    }

    @Loggable
    public void createCustomer(Customer customer) {
        logger.entering(getClass().getName(),"create");
        logger.info("i create");
        sleeper();
//        em.persist(customer);
    }

    @Loggable
    public Customer findCustomerById(Long id) {
        logger.info("i findCustomerById");
        //        return em.find(Customer23.class, id);
        sleeper();
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        logger.info("i updateCustomer");
        //        return em.find(Customer23.class, id);
        return null;
    }

    private void sleeper() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
