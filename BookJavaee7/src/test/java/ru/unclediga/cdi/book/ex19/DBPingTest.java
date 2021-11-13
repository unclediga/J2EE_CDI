package ru.unclediga.cdi.book.ex19;

import java.util.logging.Logger;



import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;

public class DBPingTest{
    private static Weld weld;
    private static WeldContainer container;
    private Logger logger = Logger.getLogger(DBPingTest.class.getName());

    @BeforeClass
    public static void init(){
        weld = new Weld();
        weld.disableDiscovery().packages(DerbyPingService.class);
        container = weld.initialize();
    }

    @AfterClass
    public static void close(){
        weld.shutdown();   
    }

    @Test
    public void HSQLPingTest(){
        logger.info("running HSQLPingTest()");
        PingService service = container.instance().select(HSQLPingService.class).get();
        assertTrue("ping() must return true", service.ping());
    }

    @Test
    public void DerbyPingTest(){
        System.err.println("running DerbyPingTest()");
        PingService service = container.instance().select(DerbyPingService.class).get();
        assertTrue("ping() must return true", service.ping());
    }
}