package com.ProjetLibre.ProjetLibre.laboratoryService.service.impI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.exception.ResourceNotFoundException;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoryRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoryService;

@Service
public class LaboratoryServiceImpI implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Override
    public void addLaboratory(Laboratory laboratory) {
        laboratoryRepository.save(laboratory);
    }

    @Override
    public Laboratory updateLaboratory(Long id, Laboratory updatedLaboratory) {
        Laboratory existingLaboratory = getLaboratoryByIdOrThrow(id);
        updateLaboratoryFields(existingLaboratory, updatedLaboratory);
        return laboratoryRepository.save(existingLaboratory);
    }

    @Override
    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepository.findAll();
    }

    @Override
    public Optional<Laboratory> getLaboratoryById(long id) {
        return laboratoryRepository.findById(id);
    }

    @Override
    public void deleteLaboratory(Long id) {
        Laboratory laboratory = getLaboratoryByIdOrThrow(id);
        laboratoryRepository.delete(laboratory);
    }

    // Méthode privée pour obtenir un laboratoire par ID ou lancer une exception
    private Laboratory getLaboratoryByIdOrThrow(Long id) {
        return laboratoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laboratoire introuvable avec l'id : " + id));
    }

    // Méthode privée pour mettre à jour les champs d'un laboratoire existant
    private void updateLaboratoryFields(Laboratory existingLaboratory, Laboratory updatedLaboratory) {
        existingLaboratory.setNom(updatedLaboratory.getNom());
        existingLaboratory.setLogo(updatedLaboratory.getLogo());
        existingLaboratory.setNrc(updatedLaboratory.getNrc());
        existingLaboratory.setStatut(updatedLaboratory.getStatut());
        existingLaboratory.setDateActivation(updatedLaboratory.getDateActivation());
    }
}
