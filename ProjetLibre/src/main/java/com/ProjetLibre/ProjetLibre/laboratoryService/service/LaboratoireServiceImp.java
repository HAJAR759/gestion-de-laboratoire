package com.ProjetLibre.ProjetLibre.laboratoryService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjetLibre.ProjetLibre.laboratoryService.exception.ResourceNotFoundException;
import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratoire;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoireRepository;

@Service
public class LaboratoireServiceImp implements LaboratoireService{

    @Autowired
    LaboratoireRepository laboratoireRepository;

    @Override
    public void ajouterLaboratoire(Laboratoire laboratoire) {
        laboratoireRepository.save(laboratoire);
    }

    
	@Override
	public Laboratoire modifierLaboratoire(Long id, Laboratoire updatedLaboratoire) {
	    return laboratoireRepository.findById(id)
	        .map(laboratoire -> {
	            laboratoire.setNom(updatedLaboratoire.getNom());
	            laboratoire.setLogo(updatedLaboratoire.getLogo());
	            laboratoire.setNrc(updatedLaboratoire.getNrc());
	            laboratoire.setStatut(updatedLaboratoire.getStatut());
	            laboratoire.setDateActivation(updatedLaboratoire.getDateActivation());
	            return laboratoireRepository.save(laboratoire);
	        }).orElseThrow(() -> new ResourceNotFoundException("Laboratoire introuvable avec l'id : " + id));
	}

	@Override
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

	@Override
    public Optional<Laboratoire> getLaboratoireById(long id) {
        return laboratoireRepository.findById(id);
    }
    
}
