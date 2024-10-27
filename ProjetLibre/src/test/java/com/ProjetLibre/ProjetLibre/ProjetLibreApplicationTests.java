package com.ProjetLibre.ProjetLibre;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;
import com.ProjetLibre.ProjetLibre.laboratoryService.repository.LaboratoryRepository;
import com.ProjetLibre.ProjetLibre.laboratoryService.service.LaboratoryService;


@SpringBootTest

class ProjetLibreApplicationTests {

    @Autowired
    private LaboratoryService service;

    @MockBean
    private LaboratoryRepository repository;

    // Test unitaire pour la méthode getAllLaboratoires
    @Test
    void testGetAllLaboratories() {
        // Créer des laboratoires fictifs:
        Laboratory lab1 = new Laboratory();
        lab1.setId(1);
        lab1.setNom("Laboratoire A");
        
        Laboratory lab2 = new Laboratory();
        lab2.setId(2);
        lab2.setNom("Laboratoire B");

        // Simuler la réponse du repository
        when(repository.findAll()).thenReturn(Arrays.asList(lab1, lab2));

        // Appeler la méthode du service
        List<Laboratory> laboratoires = service.getAllLaboratories();

        // Vérifier que le résultat est correct
        assertEquals(2, laboratoires.size());
        assertEquals("Laboratoire A", laboratoires.get(0).getNom());
        assertEquals("Laboratoire B", laboratoires.get(1).getNom());
    }

    // Test unitaire pour la méthode getLaboratoireById
    @Test
    void testGetLaboratoireById() {
    	Laboratory lab = new Laboratory();
        lab.setId(1);
        lab.setNom("Laboratoire A");

        // Simuler la réponse du repository
        when(repository.findById(1L)).thenReturn(Optional.of(lab));

        // Appeler la méthode du service
        Optional<Laboratory> laboratoire = service.getLaboratoryById(1L);

        // Vérifier que le laboratoire est récupéré correctement
        assertEquals(true, laboratoire.isPresent());
        assertEquals("Laboratoire A", laboratoire.get().getNom());
    }
    
 // Test unitaire pour la méthode AjouterLaboratoire()
    @Test
    void testAjouterLaboratoire() {
    	Laboratory lab = new Laboratory();
        lab.setId(3);
        lab.setNom("Laboratoire C");

        service.addLaboratory(lab);

        verify(repository, times(1)).save(lab);  // Vérifie que la méthode save a été appelée une fois
    }

}
