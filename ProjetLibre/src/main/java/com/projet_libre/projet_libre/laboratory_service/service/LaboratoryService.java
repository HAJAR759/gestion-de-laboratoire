package com.projet_libre.projet_libre.laboratory_service.service;

import java.util.List;
import java.util.Optional;

import com.projet_libre.projet_libre.laboratory_service.dto.LaboratoryDTO;
import com.projet_libre.projet_libre.laboratory_service.entity.Laboratory;

public interface LaboratoryService {
    // Méthode pour ajouter un laboratoire
	Laboratory addLaboratory(LaboratoryDTO laboratoryDTO);

    // Méthode pour mettre à jour un laboratoire
    Laboratory updateLaboratory(Long id, LaboratoryDTO laboratoryDTO);

    // Méthode pour obtenir tous les laboratoires
    List<Laboratory> getAllLaboratories();

    // Méthode pour obtenir un laboratoire par son identifiant
    Optional<Laboratory> getLaboratoryById(long id);

    // Méthode pour supprimer un laboratoire
    void deleteLaboratory(Long id);
}
