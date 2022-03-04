package com.springframework.sfgdi.controllers;

import com.springframework.sfgdi.services.PetService;

public class PetController {
    private final PetService petService;

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
