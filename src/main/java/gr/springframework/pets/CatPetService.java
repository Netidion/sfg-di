package gr.springframework.pets;
/**
 * Created by Neti on 4/5/2022
 */

public class CatPetService implements PetService {
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
