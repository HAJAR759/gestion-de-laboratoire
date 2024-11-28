package com.example.service_utilisateur.entities;

import com.example.service_utilisateur.model.Laboratoire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur {
    @Id
    private String cin;
    private String nomComplet;
    private String numTel;

    @Lob
    @Column(length = 100000)
    private byte[] signature;
    @Transient
    private Laboratoire laboratoire;
    private Long fkIdLaboratoire;
    @OneToOne
    private Login login;

}
