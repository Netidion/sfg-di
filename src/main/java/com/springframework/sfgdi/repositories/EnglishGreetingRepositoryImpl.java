package com.springframework.sfgdi.repositories;

/**
 * Created by Neti on 3/22/2022
 */
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World!!! --- EN";
    }
}
