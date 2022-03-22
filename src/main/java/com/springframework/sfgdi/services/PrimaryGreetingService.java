package com.springframework.sfgdi.services;

/**
 * Created by Neti on 3/22/2022
 */

public class PrimaryGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello there from the Primary Bean!!!";
    }
}
