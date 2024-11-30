package com.example.service_dossier.service;

import com.example.service_dossier.entity.Dossier;
import java.util.Date;
import java.util.List;

public interface DossierService {
    Dossier createDossier(Dossier dossier);
    Dossier getDossierById(int numDossier);
    List<Dossier> getAllDossiers();
    List<Dossier> getDossiersByDate(Date date);
    Dossier updateDossier(int numDossier, Dossier dossierDetails);
    void deleteDossier(int numDossier);
}
