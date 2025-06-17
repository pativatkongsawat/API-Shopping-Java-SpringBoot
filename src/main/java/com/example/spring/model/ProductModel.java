package com.example.spring.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    private String image;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    @Column(name = "update_at")
    private LocalDateTime update_at;


    @Column(name = "deleted_at")
    private LocalDateTime deleted_at;

    @Column(name = "category_id")
    private int category_id;


    public ProductModel(){}

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public double getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public String getImage(){return image;}
    public void setImage(String image) {this.image = image;}

    public LocalDateTime getCreatedAt() { return created_at; }
    public void setCreatedAt(LocalDateTime created_at) { this.created_at = created_at;}

    public LocalDateTime getUpdatedAt() { return update_at; }
    public void setUpdatedAt(LocalDateTime update_at) { this.update_at = update_at; }

    public LocalDateTime getDeletedAt() { return deleted_at; }
    public void setDeletedAt(LocalDateTime deleted_at) { this.deleted_at = deleted_at; }

    public int getCategoryId() {return category_id;}
    public void setCategoryId(int category_id) {this.category_id = category_id;}
    
}
