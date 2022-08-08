package com.springframework.sfgdi.config;

import com.springframework.sfgdi.datasource.FakeDataSource;
import com.springframework.sfgdi.repositories.EnglishGreetingRepository;
import com.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.springframework.sfgdi.services.*;
import gr.springframework.pets.PetService;
import gr.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * Created by Neti on 3/22/2022
 */

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${com.username}") String username,
                                  @Value("${com.password}") String password,
                                  @Value("${com.jdbcurl}") String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

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

    /*
    @Bean
    This bean has been configured in xml: sfgdi-config.xml

    ConstructorGreetingService constructorGreetingService (){
        return new ConstructorGreetingService();
    }
    */

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
