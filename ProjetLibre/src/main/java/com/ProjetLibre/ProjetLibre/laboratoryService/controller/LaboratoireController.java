package com.ProjetLibre.ProjetLibre.controller;
import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/laboratoires")
public class LaboratoireController {

    @Autowired
    private LaboratoireService laboratoireService;

    
    @GetMapping("/all")
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireService.getAllLaboratoires();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable long id) {
        Optional<Laboratoire> laboratoire = laboratoireService.getLaboratoireById(id);
        return laboratoire.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/ajouterLaboratoire")
    public void ajouPrestataire(@RequestBody Laboratoire laboratoire) {
        laboratoireService.ajouterLaboratoire(laboratoire);
    }

    @PutMapping("/modifierLabo/{id}")
    public ResponseEntity<Laboratoire> modifierLaboratoire(@PathVariable Long id, @RequestBody Laboratoire updatedLaboratoire) {
        Optional<Laboratoire> existingLaboratoire = laboratoireService.getLaboratoireById(id);

        if (existingLaboratoire.isPresent()) {
            Laboratoire modifiedLaboratoire = laboratoireService.modifierLaboratoire(id, updatedLaboratoire);
            return new ResponseEntity<>(modifiedLaboratoire, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}

