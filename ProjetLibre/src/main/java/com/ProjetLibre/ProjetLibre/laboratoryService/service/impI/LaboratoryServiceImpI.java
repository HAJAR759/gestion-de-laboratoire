package com.ProjetLibre.ProjetLibre.laboratoryService.service.impI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjetLibre.ProjetLibre.laboratoryService.exception.ResourceNotFoundException;
import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoryRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoryService;

@Service
public class LaboratoryServiceImpI implements LaboratoryService{

    @Autowired
    LaboratoryRepository laboratoryRepository;

    @Override
    public void ajouterLaboratoire(Laboratory laboratoire) {
        laboratoryRepository.save(laboratoire);
    }

    
	@Override
	public Laboratory modifierLaboratoire(Long id, Laboratory updatedLaboratory) {
	    return laboratoryRepository.findById(id)
	        .map(laboratory -> {
	            laboratory.setNom(updatedLaboratory.getNom());
	            laboratory.setLogo(updatedLaboratory.getLogo());
	            laboratory.setNrc(updatedLaboratory.getNrc());
	            laboratory.setStatut(updatedLaboratory.getStatut());
	            laboratory.setDateActivation(updatedLaboratory.getDateActivation());
	            return laboratoryRepository.save(laboratory);
	        }).orElseThrow(() -> new ResourceNotFoundException("Laboratoire introuvable avec l'id : " + id));
	}

	@Override
    public List<Laboratory> getAllLaboratories() {
        return laboratoryRepository.findAll();
    }

	@Override
    public Optional<Laboratory> getLaboratoireById(long id) {
        return laboratoryRepository.findById(id);
    }
    
}
