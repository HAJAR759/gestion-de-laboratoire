package com.example.service_laboratoire.controller;

import com.example.service_laboratoire.entities.Laboratoire;
import com.example.service_laboratoire.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/laboratoi")
public class LaboratoireController {
    @Autowired
    LaboratoireRepository l;

    @GetMapping
    public ResponseEntity<List<Laboratoire>> getLaboratoires() {
        System.out.println("Requête reçue pour /laboratoires");
        // Ajouter ici d'autres informations utiles, par exemple, les en-têtes ou les paramètres de la requête.

        return ResponseEntity.ok(l.findAll());
    }



    // Autres méthodes...
}
