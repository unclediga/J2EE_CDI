package ru.unclediga.cdi.adam;
import org.junit.Test;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class InjectionInPlainJavaTest {
    @Test
    public void injection(){
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        try(SeContainer initialize = initializer.initialize()){
            final Instance<Developer> lazyDev = initialize.select(Developer.class);
            final Developer developer = lazyDev.get();
            assertNotNull(developer);
            final String message = developer.develop();
            System.out.println("MESSAGE: " + message);
            assertThat(message, containsString("Great!"));
        }
    }

}
