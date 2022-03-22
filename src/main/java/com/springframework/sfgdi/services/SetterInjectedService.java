package com.springframework.sfgdi.services;

/**
 * Created by Neti on 3/22/2022
 */

public class SetterInjectedService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World!!! --- Setter";
    }

}
