package com.example.spring.controller;

import com.example.spring.helper.AuthRequest;
import com.example.spring.helper.AuthResponse;
import com.example.spring.model.UserModel;
import com.example.spring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest req){
        AuthResponse res = userService.Login(req);
        return ResponseEntity.ok(res);
    }
    
    public ResponseEntity<UserModel> register(@RequestBody UserModel user){

        UserModel data = userService.CreateUser(user);
        return ResponseEntity.ok(data);

    }

   
}
