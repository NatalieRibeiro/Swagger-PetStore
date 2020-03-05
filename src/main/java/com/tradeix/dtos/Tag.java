package com.tradeix.dtos;

import java.util.Objects;

public class Tag 
{
    private Integer id;
    private String name;
    
    public Tag(Integer tagId, String tagName)
    {
        this.id = tagId;
        this.name = tagName;
    }

    public Tag(){}

    public Integer getTagId()
    {
        return id;
    }

    public void setTagId(Integer tagId)
    {
        this.id = tagId;
    }

    public String getTagName()
    {
        return name;
    }

    public void SetTagName(String tagName)
    {
        this.name = tagName;
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
    
    @Override
    public String toString()
    {
        String tagPaylod = String.format("Tag{id= %d, name='%s'\\}", id, name);
        return tagPaylod;
    }
}