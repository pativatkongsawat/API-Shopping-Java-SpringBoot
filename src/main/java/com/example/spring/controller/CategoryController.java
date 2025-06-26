package com.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    public List<CategoryModel> getAllCategory(){

        return categoryService.GetAllCategory();

    }

    public ResponseEntity<CategoryModel> getByIdCategory(@PathVariable int id){

        Optional<CategoryModel> category = categoryService.GetCategoryById(id);

        return category.map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<Void> deleteCategory(@PathVariable int id){

        if(categoryService.deleteCategory(id)){
            return ResponseEntity.noContent().build();
        }

        else {
            return ResponseEntity.notFound().build();
        }

    } 

    public ResponseEntity<CategoryModel> updateCategory(@PathVariable int id , @RequestBody CategoryModel category){

        return categoryService.updateCategory(id, category).map(ResponseEntity :: ok)
               .orElse(ResponseEntity.notFound().build());

    }

}
