package com.example.spring.service;

import java.time.LocalDateTime;

import com.example.spring.model.ProductModel;
import com.example.spring.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;


    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public ProductModel createProduct(ProductModel product){

        if (product.getName() == null || product.getName().isBlank() ||
            product.getDescription() == null || product.getDescription().isBlank() ||
            product.getPrice() == 0 || product.getQuantity() == 0 ||
            product.getImage() == null || product.getImage().isBlank() ||
            product.getCategoryId() == 0
        ) {
            throw new IllegalArgumentException("กรุณากรอกข้อมูลให้ครบทุกช่อง");
        }

        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setDeletedAt(null);


        return productRepository.save(product);
    }
    
}
