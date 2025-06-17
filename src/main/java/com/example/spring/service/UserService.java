package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.spring.model.UserModel;
import com.example.spring.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<UserModel> GetAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserModel> GetById(String id) {
        return userRepository.findById(id);

    }

    public UserModel CreateUser(UserModel user) {
        if (user.getFirstname() == null || user.getFirstname().isBlank() ||
                user.getLastname() == null || user.getLastname().isBlank() ||
                user.getEmail() == null || user.getEmail().isBlank() ||
                user.getPassword() == null || user.getPassword().isBlank()) {

            throw new IllegalArgumentException("กรุณากรอกข้อมูลให้ครบทุกช่อง");
        }

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDeletedAt(null);

        return userRepository.save(user);
    }

    public Optional<UserModel> updateUser(String id, UserModel newUser) {

        boolean allFieldsBlank = (newUser.getFirstname() == null || newUser.getFirstname().isBlank()) &&
                (newUser.getLastname() == null || newUser.getLastname().isBlank()) &&
                (newUser.getEmail() == null || newUser.getEmail().isBlank()) &&
                (newUser.getPassword() == null || newUser.getPassword().isBlank()) &&
                (newUser.getAddress() == null || newUser.getAddress().isBlank()) &&
                (newUser.getPermissionId() == 0);

        if (allFieldsBlank) {
            throw new IllegalArgumentException("กรุณาใส่ข้อมูลอย่างน้อย 1 อย่างเพื่ออัปเดต");
        }

        return userRepository.findById(id).map(user -> {
            if (newUser.getFirstname() != null && !newUser.getFirstname().isBlank()) {
                user.setFirstname(newUser.getFirstname());
            }
            if (newUser.getLastname() != null && !newUser.getLastname().isBlank()) {
                user.setLastname(newUser.getLastname());
            }
            if (newUser.getEmail() != null && !newUser.getEmail().isBlank()) {
                user.setEmail(newUser.getEmail());
            }
            if (newUser.getPassword() != null && !newUser.getPassword().isBlank()) {
                user.setPassword(newUser.getPassword());
            }
            if (newUser.getAddress() != null && !newUser.getAddress().isBlank()) {
                user.setAddress(newUser.getAddress());
            }
            if (newUser.getPermissionId() != 0) {
                user.setPermissionId(newUser.getPermissionId());
            }
            if (newUser.getUpdatedBy() != null) {
                user.setUpdatedBy(newUser.getUpdatedBy());
            }

            user.setUpdatedAt(LocalDateTime.now());
            return userRepository.save(user);
        });
    }

    public boolean DeleteUser(String id){
        return userRepository.findById(id).map(user ->{
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

}
