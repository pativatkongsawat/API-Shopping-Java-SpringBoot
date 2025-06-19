package com.example.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.model.ProductModel;
import com.example.spring.repository.ProductRepository;
import com.example.spring.service.ProductService;

public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService , ProductRepository productRepository){
        this.productService = productService;
    }

    public ResponseEntity<ProductModel> CreateProduct(@RequestBody ProductModel product){

        ProductModel data = productService.createProduct(product);

        return ResponseEntity.ok(data);
    }
    
}
