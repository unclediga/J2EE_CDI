package ru.unclediga.cdi.book.ex21;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import ru.unclediga.cdi.book.LoggerProducer;

public class Main{

    private static Logger logger = Logger.getLogger(Main.class.getName());
        
    public static void main(String[] args) {
        Weld weld;
        WeldContainer container;

        weld = new Weld()
                    .disableDiscovery()
                    .packages(CustomerServiceWizard.class)
                    .beanClasses(LoggerProducer.class)
                    .property("org.jboss.weld.context.conversation.lazy", false);

        container = weld.initialize();

        logger.info("running conversationTest()");
        ContextStarter wizard = container.instance().select(ContextStarter.class).get();
        wizard.testCtx();
        //wizard.testLogger();
        //wizard.saveLogin();
        //wizard.saveAccount();
        //wizard.createCustomer();
        
        weld.shutdown();   
    }
}