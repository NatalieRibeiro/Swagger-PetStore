package com.tradeix.dtos;

public enum Status 
{
    available("available"),
    pending("pending"),
    sold("sold");

    private String status;

    Status(String petStatus)
    {
        this.status = petStatus;
    }

    @Override
    public String toString()
    {
        return String.valueOf(status);
    }
}