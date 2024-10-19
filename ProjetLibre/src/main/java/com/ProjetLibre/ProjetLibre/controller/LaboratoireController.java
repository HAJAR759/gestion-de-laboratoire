package com.ProjetLibre.ProjetLibre.controller;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.Services.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaboratoireController {
    @Autowired
    LaboratoireService laboratoireService;

    @PostMapping("/ajouterLaboratoire")
    public void ajouConducteur(@RequestBody Laboratoire laboratoire) {
        laboratoireService.ajouterLaboratoire(laboratoire);
    }


}
