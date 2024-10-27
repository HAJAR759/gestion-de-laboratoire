package com.ProjetLibre.ProjetLibre.userservice.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "utilisateur")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "fk_id_laboratoire", nullable = false)
    private Long fkIdLaboratoire;

    @Column(name = "nom_complet", nullable = false)
    private String nomComplet;

    @Column(nullable = false)
    private String profession;

    @Column(name = "num_tel")
    private String numTel;

    @Column
    private String signature;

    @Column(nullable = false)
    private String role;
}
