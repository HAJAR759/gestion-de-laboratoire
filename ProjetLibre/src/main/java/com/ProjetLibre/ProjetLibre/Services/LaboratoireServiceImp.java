package com.ProjetLibre.ProjetLibre.Services;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;
import com.ProjetLibre.ProjetLibre.repository.LaboratoireRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjetLibre.ProjetLibre.Exception.ResourceNotFoundException;

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

	// Récupérer tous les laboratoires
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

    // Récupérer un laboratoire par ID
    public Optional<Laboratoire> getLaboratoireById(long id) {
        return laboratoireRepository.findById(id);
    }
    
}
