package com.example.service_dossier.service.service_impl;

import com.example.service_dossier.entity.Dossier;
import com.example.service_dossier.repository.DossierRepository;
import com.example.service_dossier.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DossierServiceImpl implements DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    @Override
    public Dossier createDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    @Override
    public Dossier getDossierById(int numDossier) {
        Optional<Dossier> dossier = dossierRepository.findById(numDossier);
        return dossier.orElseThrow(() -> new RuntimeException("Dossier not found with ID: " + numDossier));
    }

    @Override
    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }

    @Override
    public List<Dossier> getDossiersByDate(Date date) {
        return dossierRepository.findByDate(date);
    }

    @Override
    public Dossier updateDossier(int numDossier, Dossier dossierDetails) {
        Dossier existingDossier = getDossierById(numDossier);
        existingDossier.setDate(dossierDetails.getDate());
        return dossierRepository.save(existingDossier);
    }

    @Override
    public void deleteDossier(int numDossier) {
        Dossier dossier = getDossierById(numDossier);
        dossierRepository.delete(dossier);
    }
}
