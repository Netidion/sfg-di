package com.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

/**
 * Created by Neti on 4/7/2022
 */

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton Bean!");
    }

    public String getMyScope(){
        return "I'm a Singleton";
    }

}
