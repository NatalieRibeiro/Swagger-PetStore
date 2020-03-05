package com.tradeix.dtos;

import java.util.List;
import java.util.Objects;

public class Pet 
{
    private String id;
    private Category category;
    private String name;
    private Status status;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Pet(){}

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public Category getCategory() 
    {
        return category;
    }

    public void setCategory(Category category) 
    {
        this.category = category;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public List<String> getPhotoUrls() 
    {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) 
    {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() 
    {
        return tags;
    }

    public void setTags(List<Tag> tags) 
    {
        this.tags = tags;
    }

    public Status getStatus() 
    {
        return status;
    }

    public void setStatus(Status status) 
    {
        this.status = status;
    }

    @Override
    public String toString() 
    {
        return "Pet{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object object) 
    {
        if (this == object) 
        {
            return true;
        }
        if (object == null || getClass() != object.getClass()) 
        {
            return false;
        }
        Pet pet = (Pet) object;
        return Objects.equals(this.id, pet.id) && Objects.equals(this.category, pet.category) &&
                Objects.equals(this.name, pet.name) && Objects.equals(this.photoUrls, pet.photoUrls) &&
                Objects.equals(this.tags, pet.tags) && Objects.equals(this.status, pet.status);
    }

    public static class PetBuilder 
    {
        private String id;
        private Category category;
        private String name;
        private Status status;
        private List<String> photoUrls;
        private List<Tag> tags;
        public PetBuilder() {}

        public PetBuilder withId(String id) 
        {
            this.id = id;
            return this;
        }

        public PetBuilder inCategory(Category category) {
            this.category = category;
            return this;
        }

        public PetBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PetBuilder withPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public PetBuilder withTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public PetBuilder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public Pet build() {
            Pet pet = new Pet();
            pet.id = this.id;
            pet.name = this.name;
            pet.category = this.category;
            pet.photoUrls = this.photoUrls;
            pet.tags = this.tags;
            pet.status = this.status;
            return pet;
        }
    }
}

