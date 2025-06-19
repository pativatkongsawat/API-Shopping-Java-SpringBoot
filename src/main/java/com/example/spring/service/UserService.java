package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring.config.OAuth2Config;
import com.example.spring.helper.AuthRequest;
import com.example.spring.helper.AuthResponse;
import com.example.spring.model.UserModel;
import com.example.spring.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    private OAuth2Config jwtUtil;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<UserModel> GetAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserModel> GetById(String id) {
        Optional<UserModel> users = userRepository.findById(id);
        if (users.isEmpty()) {

            throw new IllegalArgumentException("ไม่พบผู้ใช้งานไอดี = " + id);

        }
        return users;

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

    public boolean DeleteUser(String id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

    public AuthResponse login(AuthRequest req) {
        UserModel user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new NoSuchElementException("ไม่พบผู้ใช้งานด้วยอีเมลนี้"));

        if (!user.getPassword().equals(req.getPassword())) {
            throw new RuntimeException("อีเมลหรือรหัสผ่านไม่ถูกต้อง");
        }

        String token = jwtUtil.generateToken(user);
        
        AuthResponse res = new AuthResponse();
        res.setStatus("Login Success");
        res.setToken(token);
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setFirstName(user.getFirstname());
        res.setLastName(user.getLastname());
        res.setPermissionId(user.getPermissionId());

        return res;

    }
}
