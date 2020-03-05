package com.tradeix;

import com.tradeix.dtos.Category;
import com.tradeix.dtos.Pets;
import com.tradeix.dtos.Status;
import com.tradeix.dtos.Tag;
import com.tradeix.helpers.PetConstructor;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import java.util.Collections;

public class PetTest {
    PetConstructor petConstructor;
    private static final String photoUrl = "https://s3.amazonaws.com/cdn-origin-etr.akc.org/wp-content/uploads/2017/04/12185602/Lagotto-Romangolo-Tongue-Out.jpg";

    Pets pet = new Pets.PetBuilder().toPetId(RandomStringUtils.randomNumeric(5)).toPetName("Trade IX Pet")
            .toPetCategory(new Category(1, "dog"))
            .toPetTags(Collections.singletonList(new Tag(1, "nice-brown-doggy")))
            .toPetPhotoUrls(Collections.singletonList(photoUrl))
            .toPetStatus(Status.available).build();

    @BeforeClass
    public void beforeClass()
    {
        petConstructor = new PetConstructor();
    }

    @Test
    public void addPet()
    {
        Pets addResponse = petConstructor.addNewPet(pet);
        System.out.println("response is: " + addResponse);
        assertThat(addResponse, is(samePropertyValuesAs(pet)));
    }
}
