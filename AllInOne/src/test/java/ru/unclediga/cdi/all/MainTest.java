package ru.unclediga.cdi.all;

import java.util.logging.Logger;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertTrue;


public class MainTest{
    private static Weld weld;
    private static WeldContainer container;

    @BeforeClass
    public static void init(){
        weld = new Weld();
        container = weld.initialize();
    }

    @AfterClass
    public static void shutdown(){
        weld.shutdown();
    }

    @Test
    public void mainTest(){

        BookService bookService = container.select(BookService.class).get();
        Book book = bookService.createBook("The Hitchhiker's Guide to the Galaxy", 100.0F, "by Douglas Adams 1978");
        assertTrue("number must start with MOCK",book.getNumber().startsWith("MOCK"));

    }
}