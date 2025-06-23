package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.OrderHasProductModel;

public interface OrderHasProductRepository  extends JpaRepository<OrderHasProductModel , Integer>{

    
}