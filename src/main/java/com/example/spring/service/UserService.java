package com.example.spring.service;

import java.time.LocalDateTime;
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

    public UserModel CreateUser(UserModel user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDeletedAt(null);

        return userRepository.save(user);
    }
    
}
