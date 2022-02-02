package ru.unclediga.cdi.book;

import javax.enterprise.inject.Produces;

import javax.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;

public class LoggerProducer{
    private static Logger logger = Logger.getLogger(LoggerProducer.class.getName());
    @Produces
    public Logger createLogger(InjectionPoint p){
       logger.fine("logger.fine -> inject Logger into class (name = "+ p.getMember().getDeclaringClass().getName()+ ")"); 
       return Logger.getLogger(p.getMember().getDeclaringClass().getName());
    } 
}
