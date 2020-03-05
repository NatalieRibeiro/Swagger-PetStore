package com.tradeix.dtos;

import java.util.Objects;

public class Tag   
{
  private Integer id;
  private String name;

  public Tag(Integer id, String name) 
  {
    this.id = id;
    this.name = name;
  }

  public Tag() {}

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
    return "Tag{" +
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
    Tag tag = (Tag) object;
    return Objects.equals(this.id, tag.id) && Objects.equals(this.name, tag.name);
  }
}