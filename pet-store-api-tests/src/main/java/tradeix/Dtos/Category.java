import java.util.Objects;

public class Category 
{
    private String name;  
    private Integer id;
  
    public Category(Integer categoryID, String categoryName)
    {
        this.name = categoryName;
        this.id = categoryID;
    }
    
    public Category(){}

    public String getCategoryName()
    {
        return name;
    }

    public void setCategoryName(String categoryName)
    {
        this.name = categoryName;
    }

    public Integer getCategoryId()
    {
        return id;
    }

    public void setCategoryID(Integer categoryID)
    {
        this.id = categoryID;
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
        Category category = (Category) object;
        return Objects.equals(this.id, category.id) && Objects.equals(this.name, category.name);
    }

    @Override
    public String toString()
    {
        var categoryPayload = String.format("Category{id= %d, name='%s'\\}", id, name);
        return categoryPayload;
    }
}