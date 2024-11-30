package com.example.service_dossier.model;

import java.util.Date;
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
public class Patient {

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
