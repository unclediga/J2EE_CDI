package ru.unclediga.cdi.book.ex16_2;

import javax.enterprise.inject.Produces;

import javax.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;

public class LoggerProducer{
    private static Logger logger = Logger.getLogger(LoggerProducer.class.getName());
    @Produces
    public Logger createLogger(InjectionPoint p){
       logger.info("Class name "+ p.getMember().getDeclaringClass().getName()); 
       return Logger.getLogger(p.getMember().getDeclaringClass().getName());
    } 
}


