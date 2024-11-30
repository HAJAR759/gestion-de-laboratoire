package com.example.service_utilisateur.dtos;

import com.example.service_utilisateur.entities.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionUtilisateur {
    private String cin;
    private String email;
    private String mdp;
    private String nomComplet;
    private String numTel;
// Use EnumType.STRING to store enum values as strings
    private Role role;
    @Lob
    @Column(length = 100000)
    private byte[] signature;

}
