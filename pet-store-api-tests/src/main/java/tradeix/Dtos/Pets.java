import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pets 
{
    private String id;
    private String name;
    private Category category;
    private Status status;
    private List<Tag> tags;
    private List<String> photoUrl;
    private Pets(){}  
    
    public String getPetId()
    {
        return id;
    }

    public void setPetId(String petId)
    {
        this.id = petId;
    }

    public String getPetName()
    {
        return name;
    }

    public void setPetName(String petName)
    {
        this.id = petName;
    }

    public Category getPetCategory()
    {
        return category;
    }

    public void setPetCategory(Category petCategory)
    {
        this.category = petCategory;
    }

    public Status getPetStatus()
    {
        return status;
    }

    public void setPetStatus(Status petStatus)
    {
        this.status = petStatus;
    }

    public List<Tag> getPetTags()
    {
        return tags;
    }

    public void setPetTags(List<Tag> petTags)
    {
        this.tags = petTags;
    }

    public List<String> getPetPhotoUrl()
    {
        return photoUrl;
    }

    public void setPetPhotosUrl(List<String> petPhotosUrl)
    {
        this.photoUrl = petPhotosUrl;
    }

    @Override
    public String toString()
    {
        var petPayload = String.format("Pets{id= %d\\, category='%s', name='%s'\\, photoUrls= %s, tags= %s, status=%s}", id, category, name, photoUrl, tags, status);
        return petPayload;
    }

    @Override public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }

        if (object == null || getClass() != object.getClass())
        {
            return false;
        }

        Pets pet = (Pets) object;
        return Objects.equals(this.id, pet.id) && Objects.equals(this.name, pet.name) &&
               Objects.equals(this.category, pet.category) && Objects.equals(this.status, pet.status) &&
               Objects.equals(this.tags, pet.tags) && Objects.equals(this.photoUrl, pet.photoUrl);
    }

    public static class PetBuilder
    {
        private String id;
        private String name;
        private Category category;
        private Status status;
        private List<Tag> tags;
        private List<String> photoUrl;
        private PetBuilder(){}  

        public PetBuilder toPetId(String petId)
        {
            this.id = petId;
            return this;
        }

        public PetBuilder toPetName(String petName)
        {
            this.name = petName;
            return this;
        }

        public PetBuilder toPetCategory(Category petCategory)
        {
            this.category = petCategory;
            return this;
        }

        public PetBuilder toPetStatus(Status petStatus)
        {
            this.status = petStatus;
            return this;
        }

        public PetBuilder toPetTags(List<Tag> petTags)
        {
            this.tags = petTags;
            return this;
        }

        public PetBuilder toPetPhotoUrls(List<String> petPhotosUrl)
        {
            this.photoUrl = petPhotosUrl;
            return this;
        }

        public Pets build()
        {
            Pets pet = new Pets();
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