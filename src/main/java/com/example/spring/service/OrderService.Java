package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;


import com.example.spring.helper.OrderCreateRequest;
import com.example.spring.helper.RequestProduct;
import com.example.spring.model.OrderHasProductModel;
import com.example.spring.model.OrderModel;
import com.example.spring.repository.OrderHasProductRepository;
import com.example.spring.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderHasProductRepository orderHasProductRepository;

    public OrderService(OrderRepository orderRepository , OrderHasProductRepository orderHasProductRepository){
        this.orderRepository = orderRepository;
        this.orderHasProductRepository = orderHasProductRepository;
    }

    public List<OrderHasProductModel> CreateOrder(OrderCreateRequest req){

        LocalDateTime now = LocalDateTime.now();
        double totalprice = 0;

        for(RequestProduct p : req.getProducts()){

            totalprice += p.getPrice() * p.getQuantity();

        }

        OrderModel  order = new OrderModel();

        order.setCreateAt(now);
        order.setUpdateAt(now);
        order.setDeleteAt(null);
        order.setCreateBy(req.getEmail());
        order.setTotalPrice(totalprice);
        order.setUserId(req.getUserId());
        order.setStatus("unpaid");

        OrderModel saveorder = orderRepository.save(order);

         List<OrderHasProductModel> orderDetails = new ArrayList<>();
         
         for (RequestProduct p : req.getProducts()){
            OrderHasProductModel data = new OrderHasProductModel();
            data.setProductId(p.getId());
            data.setOrderID(saveorder.getId());
            data.setOrderProductTotal(p.getQuantity());
            orderDetails.add(data);


            
         }
         return orderHasProductRepository.saveAll(orderDetails);



    }

    
    
}
