package com.example.spring.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.helper.OrderCreateRequest;

import com.example.spring.model.OrderHasProductModel;
import com.example.spring.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<List<OrderHasProductModel>> createOrder(@RequestBody OrderCreateRequest order) {
        List<OrderHasProductModel> result = orderService.CreateOrder(order);
        return ResponseEntity.ok(result);
    }

}
