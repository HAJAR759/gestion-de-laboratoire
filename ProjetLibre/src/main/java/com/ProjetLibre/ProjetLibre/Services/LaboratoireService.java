package com.ProjetLibre.ProjetLibre.Services;

import java.util.List;
import java.util.Optional;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;

public interface LaboratoireService {
    public void ajouterLaboratoire(Laboratoire laboratoire);
	Laboratoire modifierLaboratoire(Long id, Laboratoire updatedLaboratoire);
	public List<Laboratoire> getAllLaboratoires();
	public Optional<Laboratoire> getLaboratoireById(long id);
}
