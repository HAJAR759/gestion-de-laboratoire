package com.example.service_utilisateur.services;

import com.example.service_utilisateur.dtos.InscriptionUtilisateur;
import com.example.service_utilisateur.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    public List<UtilisateurDto> getAllUtilisateurs();

    void ajouterUtilisateur(InscriptionUtilisateur inscriptionUtilisateur);
}
