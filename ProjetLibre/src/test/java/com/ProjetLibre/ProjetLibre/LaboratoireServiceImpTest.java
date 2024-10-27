
package com.ProjetLibre.ProjetLibre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoryRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.impI.LaboratoryServiceImpI;

import static org.mockito.Mockito.verify;

public class LaboratoireServiceImpTest {

    @Mock
    private LaboratoryRepository laboratoryRepository;

    @InjectMocks
    private LaboratoryServiceImpI laboratoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAjouterLaboratoire() {
        // Données d'entrée
        Laboratory laboratoire = new Laboratory();
        laboratoire.setNom("Laboratoire Test");

        // Appel de la méthode
        laboratoryService.ajouterLaboratoire(laboratoire);

        // Vérification
        verify(laboratoryRepository).save(laboratoire);
    }
}
