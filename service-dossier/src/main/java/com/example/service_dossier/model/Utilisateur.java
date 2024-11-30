package com.example.service_dossier.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Utilisateur {
    @Id
    private String email;
    private String nomComplet;
    private String numTel;
    @Lob
    @Column(length = 100000)
    private byte[] signature;
}
