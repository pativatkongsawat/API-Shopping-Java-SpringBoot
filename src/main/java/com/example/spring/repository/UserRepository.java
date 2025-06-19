package com.example.spring.repository;
import java.util.Optional;




import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

    Optional<UserModel> findByEmail(String email);  
}