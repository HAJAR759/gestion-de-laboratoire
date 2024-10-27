package com.ProjetLibre.ProjetLibre.laboratoryService.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    
    @GetMapping("/all")
    public List<Laboratory> getAllLaboratories() {
        return laboratoryService.getAllLaboratories();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratoireById(@PathVariable long id) {
        Optional<Laboratory> laboratoire = laboratoryService.getLaboratoireById(id);
        return laboratoire.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/ajouterLaboratoire")
    public void ajouPrestataire(@RequestBody Laboratory laboratory) {
        laboratoryService.ajouterLaboratoire(laboratory);
    }

    @PutMapping("/modifierLabo/{id}")
    public ResponseEntity<Laboratory> modifierLaboratoire(@PathVariable Long id, @RequestBody Laboratory updatedLaboratoire) {
        Optional<Laboratory> existingLaboratoire = laboratoryService.getLaboratoireById(id);

        if (existingLaboratoire.isPresent()) {
        	Laboratory modifiedLaboratoire = laboratoryService.modifierLaboratoire(id, updatedLaboratoire);
            return new ResponseEntity<>(modifiedLaboratoire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}

