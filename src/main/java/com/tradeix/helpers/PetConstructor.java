package com.tradeix.helpers;

import com.tradeix.dtos.Pets;
import com.tradeix.dtos.Status;

import java.util.List;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;


public class PetConstructor 
{
    private final RequestSpecification requestSpecification;
    public static String baseURl = "http://petstore.swagger.io/v2";
    public String petEndpoint = baseURl + "/pet";
    public String userEndpoint = baseURl + "/user";
    public String storeEndpoint = baseURl + "/store";

    public PetConstructor() 
    {
        final RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseURl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
    }

    public Pets addNewPet(Pets pet) 
    {
        return given(requestSpecification).body(pet).post(petEndpoint).as(Pets.class);
    }

    public List<Pets> getPetStatus(Status status) 
    {
        return given(requestSpecification).queryParam("status", Status.available.toString())
                .get(petEndpoint + "/findStatus").then().log().all().extract().body().jsonPath()
                .getList("", Pets.class);
    }

    public void deletePet(Pets pet) {
        given(requestSpecification).pathParam("petId", pet.getPetId()).delete(petEndpoint + "/{petId}");
    }

    public void checkPetDeleted(Pets pet) {
        given(requestSpecification).pathParam("petId", pet.getPetId()).get(petEndpoint + "/{petId}").then()
                .body(containsString("Pet not found"));
    }

    public Pets updateExistingPet(Pets pet) {
        return given(requestSpecification).body(pet).put(petEndpoint).as(Pets.class);
    }

    public Pets findPet(Pets pet)
    {
        return given(requestSpecification).pathParam("petId", pet.getPetId()).get(petEndpoint + "/{petId}").as(Pets.class);
    } 
}