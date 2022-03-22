package com.springframework.sfgdi.config;

import com.springframework.sfgdi.services.ConstructorGreetingService;
import com.springframework.sfgdi.services.PropertyInjectedGreetingService;
import com.springframework.sfgdi.services.SetterInjectedService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Neti on 3/22/2022
 */
@Configuration
public class GreetingServiceConfig {

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
}
