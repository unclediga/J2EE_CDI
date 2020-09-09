package ru.unclediga.cdi.book.customservice;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

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
        logger.entering(getClass().getName(),"findCustomerById");
        logger.info("i findCustomerById");
        //        return em.find(Customer23.class, id);
        return null;
    }

    @AroundInvoke
    public Object logMethod(InvocationContext invocationContext) throws Exception {
        logger.entering(invocationContext.getTarget().toString(),
                invocationContext.getMethod().getName());
        try {
            return invocationContext.proceed();
        } finally {
            logger.exiting(invocationContext.getTarget().toString(),
                    invocationContext.getMethod().getName());
        }
    }
}
