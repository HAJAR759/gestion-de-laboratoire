package com.example.service_utilisateur.dtos;

import com.example.service_utilisateur.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {
    private String email;
    private String nomComplet;
    private String numTel;
    private Role profession;
}
