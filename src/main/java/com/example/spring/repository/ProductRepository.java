package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel , Integer> {

    }
