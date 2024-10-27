package com.ProjetLibre.ProjetLibre.laboratoryService.service;

import java.util.List;
import java.util.Optional;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;

public interface LaboratoryService {
    public void ajouterLaboratoire(Laboratory laboratoire);
	Laboratory modifierLaboratoire(Long id, Laboratory updatedLaboratoire);
	public List<Laboratory> getAllLaboratories();
	public Optional<Laboratory> getLaboratoireById(long id);
}
