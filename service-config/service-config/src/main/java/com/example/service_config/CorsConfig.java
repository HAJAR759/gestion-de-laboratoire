package com.example.service_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Appliquer la configuration sur toutes les routes
                        .allowedOrigins("http://localhost:4200") // Permettre l'accès depuis le front-end Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Autoriser ces méthodes HTTP
                        .allowedHeaders("*") // Permettre tous les en-têtes
                        .allowCredentials(true); // Autoriser les cookies (si nécessaire)
            }
        };
    }
}
