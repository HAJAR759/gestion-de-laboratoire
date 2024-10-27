
package com.ProjetLibre.ProjetLibre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratoire;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoireRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoireServiceImp;

import static org.mockito.Mockito.verify;

public class LaboratoireServiceImpTest {

    @Mock
    private LaboratoireRepository laboratoireRepository;

    @InjectMocks
    private LaboratoireServiceImp laboratoireService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAjouterLaboratoire() {
        // Données d'entrée
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setNom("Laboratoire Test");

        // Appel de la méthode
        laboratoireService.ajouterLaboratoire(laboratoire);

        // Vérification
        verify(laboratoireRepository).save(laboratoire);
    }
}
