package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.OrderModel;

public interface OrderRepository  extends JpaRepository <OrderModel , Integer>{

    
}