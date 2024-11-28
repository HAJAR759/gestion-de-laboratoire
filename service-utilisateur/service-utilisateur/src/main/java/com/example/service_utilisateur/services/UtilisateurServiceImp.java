package com.example.service_utilisateur.services;

import com.example.service_utilisateur.dtos.InscriptionUtilisateur;
import com.example.service_utilisateur.dtos.UtilisateurDto;
import com.example.service_utilisateur.entities.Login;
import com.example.service_utilisateur.entities.Utilisateur;
import com.example.service_utilisateur.mappers.MapperService;
import com.example.service_utilisateur.repository.LoginRepository;
import com.example.service_utilisateur.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UtilisateurServiceImp implements UtilisateurService{
    @Autowired
    MapperService mapperService;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    LoginRepository loginRepository;

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateur -> mapperService.UtilisateurDtoToUtilisateur(utilisateur)) // Utilisez le mapper manuel pour chaque utilisateur
                .collect(Collectors.toList());
    }
    @Override
    public void ajouterUtilisateur(InscriptionUtilisateur inscriptionUtilisateur){

        Login login= mapperService.convertInscriptionUtilisateurToLogin(inscriptionUtilisateur);
        loginRepository.save(login);

        Utilisateur utilisateur=mapperService.convertInscriptinToUtilisateur(inscriptionUtilisateur);
        utilisateurRepository.save(utilisateur);
    }
}
