package ru.unclediga.cdi.book.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;

public class TestRandom {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        // It is moment of NumberProducer.random() and injecting
        TestRandom1 testRandom1 = container.instance().select(TestRandom1.class).get();
        // It is moment of NumberProducer.random() and injecting
        TestRandom2 testRandom2 = container.instance().select(TestRandom2.class).get();
        System.out.printf("rnd1 %f, rnd2 %f\n", testRandom1.getRnd(), testRandom2.getRnd());
        // rnd1 1519219305.000000, rnd2 71177811.000000
        weld.shutdown();
    }
}
