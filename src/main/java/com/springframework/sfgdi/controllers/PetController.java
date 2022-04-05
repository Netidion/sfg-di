package com.springframework.sfgdi.controllers;

import gr.springframework.pets.PetService;
import org.springframework.stereotype.Controller;
/**
 * Created by Neti on 4/5/2022
 */

@Controller
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
