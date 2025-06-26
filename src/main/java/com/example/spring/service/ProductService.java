package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



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

    public boolean deleteProduct(int id){
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return true;

        }).orElse(false);
    }

    public List<ProductModel> getAllProduct(){

        return productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(int id){

        Optional<ProductModel> product = productRepository.findById(id);

        if(product.isEmpty()){

            throw new IllegalArgumentException("ไม่พบสินค้าไอดี =" +id );

        }
        return product;

    }

    
    
}
