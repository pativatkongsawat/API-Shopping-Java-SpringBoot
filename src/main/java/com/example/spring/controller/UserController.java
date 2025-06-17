package com.example.spring.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.UserModel;

import com.example.spring.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final UserService userService;

    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<UserModel> getAllUser(){
        return userService.GetAllUser();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserbyId(@PathVariable String id){
       
        Optional <UserModel> user = userService.GetById(id);
        
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        
    }

    @PostMapping
    public ResponseEntity<UserModel> createuser(@RequestBody UserModel user){
        return ResponseEntity.ok(userService.CreateUser(user));
    }

    
}
