package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.ProductModel;
import com.example.spring.repository.ProductRepository;
import com.example.spring.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService , ProductRepository productRepository){
        this.productService = productService;
    }

    public ResponseEntity<ProductModel> CreateProduct(@RequestBody ProductModel product){

        ProductModel data = productService.createProduct(product);

        return ResponseEntity.ok(data);
    }

    public ResponseEntity<Void> DeleteProduct(@PathVariable int id){

        if(productService.deleteProduct(id)){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    public List<ProductModel> getAllProduct(){
        return productService.getAllProduct();
    }

    public ResponseEntity<ProductModel> getProductById(@PathVariable int id){

        Optional<ProductModel> product = productService.getProductById(id);

        return product.map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());

    }


    
}
