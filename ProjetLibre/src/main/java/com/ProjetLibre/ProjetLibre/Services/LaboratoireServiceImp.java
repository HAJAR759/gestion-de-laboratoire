package com.ProjetLibre.ProjetLibre.Services;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaboratoireServiceImp implements LaboratoireService{

    @Autowired
    LaboratoireRepository laboratoireRepository;

    @Override
    public void ajouterLaboratoire(Laboratoire laboratoire) {
        laboratoireRepository.save(laboratoire);
    }
}
