package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.model.ProductModel;
import com.example.spring.repository.ProductRepository;

@Service
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

    public Optional<ProductModel> updateProduct(int id , ProductModel product){

        LocalDateTime now = LocalDateTime.now();

        if(id <= 0){

            throw new IllegalArgumentException("ระบุไอดีสินค้าเพื่อเเก้ไข");
        }

        

        boolean productgetblank = (product.getImage() == null && product.getImage().isBlank()) ||
                                  (product.getName() == null && product.getName().isBlank())||
                                  (product.getPrice() <= 0) || (product.getQuantity() <= 0)||
                                  (product.getCategoryId() <= 0);

        if(productgetblank){
            throw new IllegalArgumentException("เพิ่มข้อมูลอย่างน้อย 1 ช่องเพื่อเเก้ไข");
        }

        return productRepository.findById(id).map(data -> {

            if(product.getName() != null && !product.getName().isBlank()){
                data.setName(product.getName());
            }

            if(product.getImage() != null && product.getImage().isBlank()){
                data.setImage(product.getImage());
            }

             if(product.getPrice() > 0){
                data.setPrice(product.getPrice());
            }

            if(product.getQuantity() > 0){
                data.setQuantity(product.getQuantity());
            }

            if(product.getCategoryId() > 0){
                data.setCategoryId(product.getCategoryId());
            }

            data.setUpdatedAt(now);

            return productRepository.save(data);

        });


    }

    
    
}
