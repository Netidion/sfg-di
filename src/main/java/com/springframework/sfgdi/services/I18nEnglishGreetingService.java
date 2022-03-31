package com.springframework.sfgdi.services;

import com.springframework.sfgdi.repositories.EnglishGreetingRepository;

/**
 * Created by Neti on 3/22/2022
 */

public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World!!! --- EN";
    }
}
