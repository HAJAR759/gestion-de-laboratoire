package com.example.service_utilisateur.entities;

import com.example.service_utilisateur.model.Laboratoire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    private String email;
    private String nomComplet;
    private String numTel;
    @Lob
    @Column(length = 100000)
    private byte[] signature;
    @Transient
    private Laboratoire laboratoire;
    private Long fkIdLaboratoire;
}
