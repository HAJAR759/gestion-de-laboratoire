package com.ProjetLibre.ProjetLibre.controller;

<<<<<<< HEAD
import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> cdf3174a947df4ba3b39a60e4eb4fc07214087d0

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireServiceImp;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {
    @Autowired
    LaboratoireService laboratoireService;

    @PostMapping("/ajouterLaboratoire")
    public void ajouConducteur(@RequestBody Laboratoire laboratoire) {
        laboratoireService.ajouterLaboratoire(laboratoire);
    }

    @Autowired
    private LaboratoireServiceImp laboratoireService;

    // Récupérer tous les laboratoires
    @GetMapping("/all")
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireService.getAllLaboratoires();
    }

    // Récupérer un laboratoire par ID
    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable long id) {
        Optional<Laboratoire> laboratoire = laboratoireService.getLaboratoireById(id);
        return laboratoire.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
}

