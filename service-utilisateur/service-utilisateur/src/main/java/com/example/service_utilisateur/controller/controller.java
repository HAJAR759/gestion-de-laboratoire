package com.example.service_utilisateur.controller;

import com.example.service_utilisateur.clients.LaboratoireRestClient;
import com.example.service_utilisateur.model.Laboratoire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {
    @Autowired
    LaboratoireRestClient laboratoireRestClient;

    @GetMapping("labo")
    public List<Laboratoire> accountList(){
        System.out.println("labusr");
        return laboratoireRestClient.findAllLaboratoires();
    }
}
