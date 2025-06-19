package com.example.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.model.CategoryModel;
import com.example.spring.service.CategoryService;

public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }


    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryModel category){
        CategoryModel data = categoryService.CreateCategory(category);

        return ResponseEntity.ok(data);
    }

}
