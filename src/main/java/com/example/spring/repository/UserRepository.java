package com.example.spring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel , UUID>{

    
}