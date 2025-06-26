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

    public CategoryModel CreateCategory(CategoryModel category){

        if(category.getName() == null || category.getName().isBlank()){

            throw new IllegalArgumentException("กรุณาใส่ชื่อหมวดหมู่เพื่อเพิ่ม");

        }

        return categoryRepository.save(category);

    }

    public List<CategoryModel> getAllCategory(){
        return categoryRepository.findAll();
    }

    public Optional<CategoryModel> getByIdCategory(int id){

        Optional<CategoryModel> data = categoryRepository.findById(id);

        if(data.isEmpty()){

            throw new IllegalArgumentException("ไม่พบหมวดหมู่ไอดีนี้ = " + id);

        }


        return data;

    }

    public boolean deleteCategory(int id){
       
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return true;

        }).orElse(false);
       
    }

    public Optional<CategoryModel> updateCategory(int id , CategoryModel category){

        if(id <=0){

            throw new IllegalArgumentException("ระบุไอดีเพื่อเเก้ไขหมวดหมู่");

        }

        boolean categorynullisbank = (category.getName() == null && category.getName().isBlank());


        if(categorynullisbank){

            throw new IllegalArgumentException("ระบุข้อมูลหนึ่งช่องสำหรับเเก้ไขข้อมูล");

        }

        return categoryRepository.findById(id).map(data ->{

            if(category.getName() != null && !category.getName().isBlank()){
                data.setName(category.getName());
            }
            
            categoryRepository.save(data);
            return data;

        });

    }
}