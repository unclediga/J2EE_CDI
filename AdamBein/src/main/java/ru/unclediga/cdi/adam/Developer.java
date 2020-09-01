package ru.unclediga.cdi.adam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Developer {
    @Inject
    Coffee coffee;

    public String develop(){
        return coffee.drink() + "Let's the development begin!";
    }
}
