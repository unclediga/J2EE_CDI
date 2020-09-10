package ru.unclediga.cdi.book.bookservice;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;

public class TestRandom2 {
    @Inject
    @MyRandom
    private double rnd;

    public double getRnd() {
        return rnd;
    }
}
