package com.ProjetLibre.ProjetLibre.laboratoryService.service.impI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.mapper.Mapper;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoryRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoryService;
import com.ProjetLibre.ProjetLibre.laboratoryService.dto.LaboratoryDTO;

@Service
public class LaboratoryServiceImpI implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    private final Mapper mapper = new Mapper();

    @Override
    public Laboratory addLaboratory(LaboratoryDTO laboratoryDTO) {
        // Convertir le DTO en entité et l'ajouter à la base de données
        Laboratory laboratory = mapper.toEntity(laboratoryDTO);
        return laboratoryRepository.save(laboratory);
    }

    @Override
    public Laboratory updateLaboratory(Long id, LaboratoryDTO laboratoryDTO) {
        Optional<Laboratory> existingLaboratory = laboratoryRepository.findById(id);
        if (existingLaboratory.isPresent()) {
            Laboratory laboratoryToUpdate = existingLaboratory.get();
            laboratoryToUpdate.setNom(laboratoryDTO.getNom());
            laboratoryToUpdate.setLogo(laboratoryDTO.getLogo());
            laboratoryToUpdate.setNrc(laboratoryDTO.getNrc());
            laboratoryToUpdate.setStatut(laboratoryDTO.getStatut());
            laboratoryToUpdate.setDateActivation(laboratoryDTO.getDateActivation());
            return laboratoryRepository.save(laboratoryToUpdate);
        }
        return null; // ou lancez une exception si le laboratoire n'existe pas
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
        laboratoryRepository.deleteById(id);
    }
}
