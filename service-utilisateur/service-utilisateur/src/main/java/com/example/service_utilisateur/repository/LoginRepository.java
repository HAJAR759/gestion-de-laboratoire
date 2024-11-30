package com.example.service_utilisateur.repository;


import com.example.service_utilisateur.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,String> {
    Login findLoginByEmail(String email);
}
