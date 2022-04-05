package com.springframework.sfgdi.config;

import com.springframework.sfgdi.repositories.EnglishGreetingRepository;
import com.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.springframework.sfgdi.services.*;
import gr.springframework.pets.CatPetService;
import gr.springframework.pets.DogPetService;
import gr.springframework.pets.PetService;
import gr.springframework.pets.PetServiceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by Neti on 3/22/2022
 */
@Configuration
public class GreetingServiceConfig {

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ESP","default"})
    @Bean  ("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService (){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedService setterInjectedService(){
        return new SetterInjectedService();
    }


    /**
     * Configuration for package: gr.springframework.pets
     */
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean
    @Profile("cat")
    PetService catPetService (PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService (PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }


}
