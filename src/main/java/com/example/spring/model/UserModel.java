package com.example.spring.model;



import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    private String id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;


    private String address;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    @Column(name = "permission_id")
    private int permissionId;

    @Column(name = "updated_by")
    private String updatedBy;

    
}
