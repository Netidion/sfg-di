package com.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;

@Profile({"dog", "default"})
public class DogPetService {
    public String getPetType(){
        return "Dogs are the best!";
    }
}
