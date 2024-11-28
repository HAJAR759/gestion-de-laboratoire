package com.example.service_utilisateur.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("Login")
@NoArgsConstructor
@Setter
@Getter
public class Login {
    @Id

    private String email;
    private String mdp;
    @Enumerated(EnumType.STRING) // Use EnumType.STRING to store enum values as strings
    private Role role;
}