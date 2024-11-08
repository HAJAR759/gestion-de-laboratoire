package com.example.service_laboratoire.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laboratoire {
    @Id
    private long id;
    private String nom;
    @Lob
    @Column(length = 100000)
    private byte[] logo;
    private Long  nrc;
    private Statut statut;
    private Date dateActivation;
    
    

    
    
}
