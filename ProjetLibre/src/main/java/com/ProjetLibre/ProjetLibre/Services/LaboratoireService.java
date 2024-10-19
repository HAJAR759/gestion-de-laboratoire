package com.ProjetLibre.ProjetLibre.Services;

import java.util.List;
import java.util.Optional;

import com.ProjetLibre.ProjetLibre.Entities.Laboratoire;

import java.util.List;
import java.util.Optional;

public interface LaboratoireService {
    public void ajouterLaboratoire(Laboratoire laboratoire);
	Laboratoire modifierLaboratoire(Long id, Laboratoire updatedLaboratoire);
<<<<<<< HEAD
    public List<Laboratoire> getAllLaboratoires();
    public Optional<Laboratoire> getLaboratoireById(long id);

=======
	public List<Laboratoire> getAllLaboratoires();
	public Optional<Laboratoire> getLaboratoireById(long id);
>>>>>>> b7803b0fc92077cda8d4ded1e489d014795d0e55
}
