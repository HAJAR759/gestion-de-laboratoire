package com.projet_libre.projet_libre.laboratory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.projet_libre.projet_libre.laboratory_service.dto.LaboratoryDTO;
import com.projet_libre.projet_libre.laboratory_service.entity.Laboratory;
import com.projet_libre.projet_libre.laboratory_service.entity.Statut;
import com.projet_libre.projet_libre.laboratory_service.service.LaboratoryService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResponseEntity<Laboratory> addLaboratory(
            @RequestParam("nom") String nom,
            @RequestParam("nrc") Long nrc,
            @RequestParam("statut") int statutString,
            @RequestParam("date_activation") String dateActivation,
            @RequestParam(value = "logo", required = false) MultipartFile logo) throws ParseException {

        // Convertir le MultipartFile en byte[] si le fichier est présent
        byte[] logoBytes = null;
        if (logo != null && !logo.isEmpty()) {
            try {
                logoBytes = logo.getBytes();
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        }

        // Créer le DTO avec les autres données
        LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
        laboratoryDTO.setNom(nom);
        laboratoryDTO.setNrc(nrc);
     // Exemple dans votre contrôleur
        Statut statut = Statut.fromInt(statutString); // Convert String to Statut enum
        laboratoryDTO.setStatut(statut); // Pass the enum value
     // Assurez-vous que la date est dans un format valide
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format de date attendu
        Date date;
        try {
            date = dateFormat.parse(dateActivation);
        } catch (ParseException e) {
            // Si la date n'est pas valide, retourner une erreur 400 avec message explicatif
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Vous pouvez également ajouter un message d'erreur dans le corps de la réponse.
        }
        laboratoryDTO.setDateActivation(date);
        laboratoryDTO.setLogo(logoBytes); // Ajout du logo

        // Ajouter le laboratoire dans la base de données
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
