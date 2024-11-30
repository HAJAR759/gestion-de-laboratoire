package com.example.service_patient.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

	@Id
	private int idPatient;
	private String nomcomplet;
	private Date dateNaissance;
	private String lieuDeNaissance;
	private String sexe;
	private String typePieceIdentite;
	private String numPieceIdentite;
	private String adresse;
	private String numTel;
	private String email;
	private String visible_pour;
}
