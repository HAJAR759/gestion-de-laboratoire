package com.example.service_dossier.entity;

import java.util.Date;

import com.example.service_dossier.model.Patient;
import com.example.service_dossier.model.Utilisateur;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dossier {
	@Id
	private int numDossier;
	private Date date;
	
	@Transient
    private Utilisateur utilisateur;
    private String fkEmailUtilisateur;
    @Transient
    private Patient patient;
    private String fkIdPatient;
    
	public int getNumDossier() {
		return numDossier;
	}
	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
