package com.example.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.spring.model.UserModel;
import com.example.spring.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public List<UserModel> GetAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserModel> GetById(UUID id){
        return userRepository.findById(id);

    }
    
}
