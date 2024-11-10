package com.projet_libre.projet_libre.laboratory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projet_libre.projet_libre.laboratory_service.dto.LaboratoryDTO;
import com.projet_libre.projet_libre.laboratory_service.entity.Laboratory;
import com.projet_libre.projet_libre.laboratory_service.service.LaboratoryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoryController {

    private LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }
    
    // Récupérer tous les laboratoires
    @GetMapping("/all")
    public ResponseEntity<List<Laboratory>> getAllLaboratories() {
        List<Laboratory> laboratories = laboratoryService.getAllLaboratories();
        return ResponseEntity.ok(laboratories);
    }

    // Récupérer un laboratoire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Laboratory> getLaboratoireById(@PathVariable Long id) {
        Optional<Laboratory> laboratoire = laboratoryService.getLaboratoryById(id);
        return laboratoire.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

 // Ajouter un nouveau laboratoire
    @PostMapping("/ajouterLaboratoire")
    public ResponseEntity<Laboratory> addLaboratory(@RequestBody LaboratoryDTO laboratoryDTO) {
        Laboratory laboratory = laboratoryService.addLaboratory(laboratoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(laboratory);
    }

    // Mettre à jour un laboratoire existant
    @PutMapping("/modifierLabo/{id}")
    public ResponseEntity<Laboratory> updateLaboratory(@PathVariable Long id, @RequestBody LaboratoryDTO updatedLaboratoryDTO) {
        try {
            Laboratory updatedLab = laboratoryService.updateLaboratory(id, updatedLaboratoryDTO);
            return ResponseEntity.ok(updatedLab);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Supprimer un laboratoire
    @DeleteMapping("/supprimerLabo/{id}")
    public ResponseEntity<Void> deleteLaboratory(@PathVariable Long id) {
        try {
            laboratoryService.deleteLaboratory(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
