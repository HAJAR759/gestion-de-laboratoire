package com.ProjetLibre.ProjetLibre.controller;

<<<<<<< HEAD
import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireService;

>>>>>>> b7803b0fc92077cda8d4ded1e489d014795d0e55
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {

<<<<<<< HEAD
=======
    @Autowired
    private LaboratoireService laboratoireService;
>>>>>>> b7803b0fc92077cda8d4ded1e489d014795d0e55

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

