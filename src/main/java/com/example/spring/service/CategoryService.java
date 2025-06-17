package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import com.example.spring.model.CategoryModel;

import com.example.spring.repository.CategoryRepository;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> GetAllCategory() {
        return categoryRepository.findAll();
    }

    public Optional<CategoryModel> GetCategoryById(Integer id) {

        Optional<CategoryModel> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            throw new IllegalArgumentException("ไม่พบหมวดหมู่");
        }

        return category;
    }
}