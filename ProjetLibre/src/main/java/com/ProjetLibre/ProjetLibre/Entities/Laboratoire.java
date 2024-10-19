package com.ProjetLibre.ProjetLibre.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
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
