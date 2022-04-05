package gr.springframework.pets;

/**
 * Created by Neti on 4/5/2022
 */

public class PetServiceFactory {

    public PetService getPetService (String peType){
        switch (peType){
            case "cat":
                return new CatPetService();
            case "dog":
                return new DogPetService();
            default:
                return new DogPetService();
        }

    }
}
