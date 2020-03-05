package com.tradeix.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pets 
{
    private String id;
    private String name;
    private Category category;
    private Status status;
    private List<Tag> tags = new ArrayList<>();
    private List<String> photoUrl = new ArrayList<>();
    private Pets(){}  
    
    public String getPetId()
    {
        return id;
    }

    public void setPetId(String id) {
        this.id = id;
    }

    public String getPetName() {
        return name;
    }

    public void setPetName(String name) {
        this.name = name;
    }

    public Category getPetCategory() {
        return category;
    }

    public void setPetCategory(Category category) {
        this.category = category;
    }

    public Status getPetStatus() {
        return status;
    }

    public void setPetStatus(Status status) {
        this.status = status;
    }

    public List<Tag> getPetTags() {
        return tags;
    }

    public void setPetTags(List<Tag> tag) {
        this.tags = tag;
    }

    public List<String> getPetPhotoUrl() {
        return photoUrl;
    }

    public void setPetPhotosUrl(List<String> photosUrl) {
        this.photoUrl = photosUrl;
    }

    @Override
    public String toString() {
        final String petPayload = String.format(
                "Pets{id='%d'\\, category='%s', name='%s'\\, photoUrls= %s, tags= %s, status=%s}", id, category, name,
                photoUrl, tags, status);
        return petPayload;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Pets pet = (Pets) object;
        return Objects.equals(this.id, pet.id) && Objects.equals(this.name, pet.name)
                && Objects.equals(this.category, pet.category) && Objects.equals(this.status, pet.status)
                && Objects.equals(this.tags, pet.tags) && Objects.equals(this.photoUrl, pet.photoUrl);
    }

    public static class PetBuilder {
        private String id;
        private String name;
        private Category category;
        private Status status;
        private List<Tag> tags;
        private List<String> photoUrl;

        public PetBuilder() {
        }

        public PetBuilder toPetId(String id) {
            this.id = id;
            return this;
        }

        public PetBuilder toPetName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder toPetCategory(Category category) {
            this.category = category;
            return this;
        }

        public PetBuilder toPetStatus(Status status) {
            this.status = status;
            return this;
        }

        public PetBuilder toPetTags(List<Tag> tag) {
            this.tags = tag;
            return this;
        }

        public PetBuilder toPetPhotoUrls(List<String> photosUrl) {
            this.photoUrl = photosUrl;
            return this;
        }

        public Pets build() {
            final Pets pet = new Pets();
            pet.id = this.id;
            pet.name = this.name;
            pet.category = this.category;
            pet.status = this.status;
            pet.tags = this.tags;
            pet.photoUrl = this.photoUrl;
            return pet;
        }
    }
}