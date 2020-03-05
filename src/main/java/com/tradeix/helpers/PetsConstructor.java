package com.tradeix.helpers;

import java.util.List;
import com.tradeix.dtos.Pet;
import com.tradeix.dtos.Status;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class PetsConstructor 
{
    public static String baseUrl = "http://petstore.swagger.io/v2";
    public static String petEndpoint = baseUrl + "/pet";
    private RequestSpecification requestSpecification;

    public PetsConstructor() 
    {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
    }

    public Pet addNewPet(Pet pet) 
    {
        return given(requestSpecification).body(pet).post(petEndpoint).as(Pet.class);
    }

    public List<Pet> getPetsByStatus(Status status) 
    {
        return given(requestSpecification).queryParam("status", Status.available.toString()).get(petEndpoint + "/findByStatus")
        .then().log().all().extract().body().jsonPath().getList("", Pet.class);
    }

    public void deletePet(Pet pet) 
    {
        given(requestSpecification).pathParam("petId", pet.getId()).delete(petEndpoint + "/{petId}");
    }

    public void verifyPetDeleted(Pet pet) 
    {
        given(requestSpecification).pathParam("petId", pet.getId()).get(petEndpoint + "/{petId}")
        .then().body(containsString("Pet not found"));
    }

    public Pet findPet(Pet pet) 
    {
        return given(requestSpecification).pathParam("petId", pet.getId()).get(petEndpoint + "/{petId}").as(Pet.class);
    }

    public Pet updatePet(Pet pet) 
    {
        return given(requestSpecification).body(pet).put(petEndpoint).as(Pet.class);
    }
}