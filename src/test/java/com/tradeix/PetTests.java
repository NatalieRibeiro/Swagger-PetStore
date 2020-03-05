package com.tradeix;

import java.util.Collections;
import com.tradeix.dtos.*;
import com.tradeix.helpers.PetsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

public class PetTests {
    private static final String photoUrl = "https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg";
    PetsConstructor petsConstructor;
    Pet pet = new Pet.PetBuilder()
            .withId(RandomStringUtils.randomNumeric(5))
            .inCategory(new Category(3, "cats"))
            .withName("TradeIX Pet")
            .withStatus(Status.available)
            .withPhotoUrls(Collections.singletonList(photoUrl))
            .withTags(Collections.singletonList(new Tag(2, "Green-eyes"))).build();

    @Test
    public void petTests() {
        petsConstructor = new PetsConstructor();

        System.out.println("Add new Pet");
        Pet petResponse = petsConstructor.addNewPet(pet);
        assertThat(petResponse, is(samePropertyValuesAs(pet)));
 
        System.out.println("Check Pet was created");
        Pet checkResponse = petsConstructor.findPet(pet);
        assertThat(checkResponse, is(samePropertyValuesAs(pet)));
    
        System.out.println("Change Pet Name");
        pet.setName("Trade Cat");
        Pet updateResponse = petsConstructor.updatePet(pet);
        assertThat(updateResponse, is(samePropertyValuesAs(pet)));

        System.out.println("Check Pet Name was updated");
        Pet newNameResponse = petsConstructor.findPet(pet);
        assertThat(newNameResponse, is(samePropertyValuesAs(pet)));
    
        System.out.println("Delete Pet");
        petsConstructor.deletePet(pet);
        petsConstructor.verifyPetDeleted(pet);
    }
}