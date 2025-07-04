package com.example.spring.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime create_at;
    private LocalDateTime updated_at;
    private LocalDateTime deleted_at;

    private double total_price;
    private String created_by;
    private String status = "unpaid";

   

    private String user_id;

    
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getCreateAt() { return create_at; }
    public void setCreateAt(LocalDateTime create_at) { this.create_at = create_at; }

    public LocalDateTime getUpdateAt() { return updated_at; }
    public void setUpdateAt(LocalDateTime updated_at) { this.updated_at = updated_at; }

    public LocalDateTime getDeleteAt() { return deleted_at; }
    public void setDeleteAt(LocalDateTime deleted_at) { this.deleted_at = deleted_at; }

    public double getTotalPrice() { return total_price; }
    public void setTotalPrice(double total_price) { this.total_price = total_price; }

    public String getCreateBy() { return created_by; }
    public void setCreateBy(String created_by) { this.created_by = created_by; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getUser_id(){return user_id;}
    public void setUser_id(String user_id){this.user_id = user_id;}


}
