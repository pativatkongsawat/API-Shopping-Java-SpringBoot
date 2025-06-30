package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.config.OAuth2Config;
import com.example.spring.helper.OrderCreateRequest;
import com.example.spring.helper.RequestProduct;
import com.example.spring.model.OrderHasProductModel;
import com.example.spring.model.OrderModel;
import com.example.spring.model.UserModel;
import com.example.spring.repository.OrderHasProductRepository;
import com.example.spring.repository.OrderRepository;
import com.example.spring.repository.UserRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderHasProductRepository orderHasProductRepository;
    private final UserRepository userRepository;
    private final OAuth2Config jwtUtil;

    public OrderService(
            OrderRepository orderRepository,
            OrderHasProductRepository orderHasProductRepository,
            UserRepository userRepository,
            OAuth2Config jwtUtil
    ) {
        this.orderRepository = orderRepository;
        this.orderHasProductRepository = orderHasProductRepository;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public List<OrderHasProductModel> CreateOrder(OrderCreateRequest req, HttpServletRequest request) {
        LocalDateTime now = LocalDateTime.now();
        double totalPrice = 0;

      
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Authorization header missing or invalid");
        }
        String token = authHeader.substring(7);

    
        Claims claims = jwtUtil.extractAllClaims(token);
        String email = claims.getSubject();
       
        String userId = claims.get("id", String.class);
       

        
        for (RequestProduct p : req.getProducts()) {
            totalPrice += p.getPrice() * p.getQuantity();
        }

        
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

       
        OrderModel order = new OrderModel();
        order.setCreateAt(now);
        order.setUpdateAt(now);
        order.setDeleteAt(null);
        order.setCreateBy(email);
        order.setTotalPrice(totalPrice);
        order.setUser(user);
        order.setStatus("unpaid");

        OrderModel savedOrder = orderRepository.save(order);

        // ✅ สร้าง OrderHasProductModel สำหรับแต่ละสินค้า
        List<OrderHasProductModel> orderDetails = new ArrayList<>();
        for (RequestProduct p : req.getProducts()) {
            OrderHasProductModel item = new OrderHasProductModel();
            item.setProductId(p.getId());
            item.setOrderID(savedOrder.getId());
            item.setOrderProductTotal(p.getQuantity());
            orderDetails.add(item);
        }

        return orderHasProductRepository.saveAll(orderDetails);
    }
}
