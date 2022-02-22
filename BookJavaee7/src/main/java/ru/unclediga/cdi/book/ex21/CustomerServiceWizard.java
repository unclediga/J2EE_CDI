package ru.unclediga.cdi.book.ex21;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;

//import org.jboss.weld.environment.se.contexts.activators.ActivateThreadScope;

//@ActivateThreadScope
@ConversationScoped
public class CustomerServiceWizard implements Serializable{

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Login login;
    private Account account;
    
    private @Inject Conversation conversation;
    //@Inject
    private CustomerService customerService;

    public void testLogger(){    
        logger.info("TEST LOGGER");
        logger.info("CONV = " + conversation);
    }  

    public void saveLogin(){
        conversation.begin();
        logger.info("Enter saveLogin()");
        login = new Login();
    }
    
    public void saveAccount(){
        logger.info("Enter saveAccount()");
        account = new Account();
    }
    public void createCustomer(){
        logger.info("Enter createCustomer() conversation=" + conversation);
        Customer customer = new Customer("test", "test", "test");
        customer.setAccount(account);
        customer.setLogin(login);
        conversation.end();
    }
}
