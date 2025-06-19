package com.example.spring.service;

import com.example.spring.model.ProductModel;
import com.example.spring.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;


    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public ProductModel createProduct(ProductModel product){
        return productRepository.save(product);
    }
    
}
