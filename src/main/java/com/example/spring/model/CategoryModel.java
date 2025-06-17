package com.example.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    private String name;

    public CategoryModel(){};

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
}
