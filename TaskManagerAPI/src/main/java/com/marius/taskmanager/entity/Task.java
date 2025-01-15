package com.marius.taskmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate IDs
    private Long id; 

    private String name;
    private String description;

    // Default constructor (required for JPA)
    public Task() {}

    // Getters and Setters
    public Long getId() 
    {
        return id;
    }

    public void setId(Long id)
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

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description)
     {
        this.description = description;
    }
}

