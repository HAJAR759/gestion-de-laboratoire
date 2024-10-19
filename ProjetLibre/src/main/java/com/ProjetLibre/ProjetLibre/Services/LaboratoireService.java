package com.ProjetLibre.ProjetLibre.Services;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;

import java.util.List;
import java.util.Optional;

public interface LaboratoireService {
    public void ajouterLaboratoire(Laboratoire laboratoire);
	Laboratoire modifierLaboratoire(Long id, Laboratoire updatedLaboratoire);
    public List<Laboratoire> getAllLaboratoires();
    public Optional<Laboratoire> getLaboratoireById(long id);

}
