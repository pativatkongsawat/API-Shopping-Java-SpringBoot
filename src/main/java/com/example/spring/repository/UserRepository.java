package com.example.spring.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel ,String>{

}