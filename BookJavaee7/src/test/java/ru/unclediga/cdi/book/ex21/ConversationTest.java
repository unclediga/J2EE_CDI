package ru.unclediga.cdi.book.ex21;

import java.util.logging.Logger;



import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

public class ConversationTest{
    private static Weld weld;
    private static WeldContainer container;
    private Logger logger = Logger.getLogger(ConversationTest.class.getName());

    @BeforeClass
    public static void init(){
        weld = new Weld();
        weld.disableDiscovery().packages(CustomerServiceWizard.class);
        weld.property("org.jboss.weld.context.conversation.lazy", false);
        container = weld.initialize();
        
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }

    @Test
    public void conversationTest(){
        logger.info("running conversationTest()");
        CustomerServiceWizard wizard = container.instance().select(CustomerServiceWizard.class).get();
//        wizard.saveLogin();
//        wizard.saveAccount();
//        wizard.createCustomer();
        assertTrue("DO TEST!", true);
    }
}