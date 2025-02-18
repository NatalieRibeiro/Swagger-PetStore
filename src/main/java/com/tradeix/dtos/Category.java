package com.tradeix.dtos;

import java.util.Objects;

public class Category   
{
  private Integer id = null;
  private String name = null;

  public Category(Integer id, String name) 
  {
    this.id = id;
    this.name = name;
  }

  public Category(){}

  public Integer getId() 
  {
    return id;
  }

  public void setId(Integer id) 
  {
    this.id = id;
  }

  public String getName() 
  {
    return name;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  @Override
  public String toString() 
  {
    return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
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
    Category category = (Category) object;
    return Objects.equals(this.id, category.id) && Objects.equals(this.name, category.name);
  }
}