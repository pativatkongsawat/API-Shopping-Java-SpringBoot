package com.example.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.CategoryModel;

public interface CategoryRepository  extends JpaRepository<CategoryModel , Integer>{

    
}