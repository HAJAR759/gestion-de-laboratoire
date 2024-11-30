package com.example.service_dossier.repository;

import com.example.service_dossier.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DossierRepository extends JpaRepository<Dossier, Integer> {
    // Exemple de méthode personnalisée pour trouver les dossiers par date
    List<Dossier> findByDate(Date date);
}
