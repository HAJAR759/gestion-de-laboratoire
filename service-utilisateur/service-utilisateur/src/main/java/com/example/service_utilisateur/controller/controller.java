package com.example.service_utilisateur.controller;

import com.example.service_utilisateur.clients.LaboratoireRestClient;
import com.example.service_utilisateur.dtos.InscriptionUtilisateur;
import com.example.service_utilisateur.dtos.UtilisateurDto;
import com.example.service_utilisateur.model.Laboratoire;
import com.example.service_utilisateur.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class controller {
    @Autowired
    LaboratoireRestClient laboratoireRestClient;
    @Autowired
    UtilisateurService utilisateurService;

    @GetMapping("labo")
    public List<Laboratoire> accountList(){
        System.out.println("labusr");
        return laboratoireRestClient.findAllLaboratoires();
    }
    @GetMapping("utilisateurs")
    public List<UtilisateurDto> getAllUtilisateurs(){
        System.out.println("labusr");
        return utilisateurService.getAllUtilisateurs();
    }
    @PostMapping("/ajouUtilisateur")
    public void ajouUtilisateur(@RequestBody InscriptionUtilisateur inscription) {
        utilisateurService.ajouterUtilisateur(inscription);
    }
}
