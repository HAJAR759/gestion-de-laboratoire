package com.projet_libre.projet_libre;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projet_libre.projet_libre.laboratory_service.entity.Laboratory;
import com.projet_libre.projet_libre.laboratory_service.entity.Statut;
import com.projet_libre.projet_libre.laboratory_service.mapper.Mapper;
import com.projet_libre.projet_libre.laboratory_service.repository.LaboratoryRepository;
import com.projet_libre.projet_libre.laboratory_service.service.service_impl.LaboratoryServiceImpl;
import com.projet_libre.projet_libre.laboratory_service.dto.LaboratoryDTO;

 class LaboratoryServiceImpTest {

    @Mock
    private LaboratoryRepository laboratoryRepository;

    @InjectMocks
    private LaboratoryServiceImpl laboratoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testAjouterLaboratoire() {
        LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
        laboratoryDTO.setNom("Laboratoire A");
        laboratoryDTO.setNrc(123456L);
        laboratoryDTO.setStatut(Statut.ACTIF); // Supposons que Statut est une énumération
        laboratoryDTO.setDateActivation(new Date());

        Laboratory laboratory = Mapper.toEntity(laboratoryDTO);
        
        when(laboratoryRepository.save(any(Laboratory.class))).thenReturn(laboratory);

        Laboratory result = laboratoryService.addLaboratory(laboratoryDTO);

        assertNotNull(result);
        assertEquals(laboratoryDTO.getNom(), result.getNom());
        assertEquals(laboratoryDTO.getNrc(), result.getNrc());
        verify(laboratoryRepository, times(1)).save(any(Laboratory.class));
    }

    @Test
     void testModifierLaboratoire() {
        Long labId = 1L;
        Laboratory existingLaboratory = new Laboratory();
        existingLaboratory.setId(labId);
        existingLaboratory.setNom("Laboratoire A");
        
        LaboratoryDTO laboratoryDTO = new LaboratoryDTO();
        laboratoryDTO.setNom("Laboratoire A Modifié");
        laboratoryDTO.setNrc(123456L);
        laboratoryDTO.setStatut(Statut.ACTIF);
        laboratoryDTO.setDateActivation(new Date());

        when(laboratoryRepository.findById(labId)).thenReturn(Optional.of(existingLaboratory));
        when(laboratoryRepository.save(any(Laboratory.class))).thenReturn(existingLaboratory);

        Laboratory updatedLaboratory = laboratoryService.updateLaboratory(labId, laboratoryDTO);

        assertNotNull(updatedLaboratory);
        assertEquals(laboratoryDTO.getNom(), updatedLaboratory.getNom());
        verify(laboratoryRepository, times(1)).save(any(Laboratory.class));
    }

    @Test
     void testObtenirTousLesLaboratoires() {
        Laboratory lab1 = new Laboratory();
        lab1.setNom("Laboratoire 1");
        Laboratory lab2 = new Laboratory();
        lab2.setNom("Laboratoire 2");

        when(laboratoryRepository.findAll()).thenReturn(Arrays.asList(lab1, lab2));

        List<Laboratory> laboratories = laboratoryService.getAllLaboratories();

        assertEquals(2, laboratories.size());
        verify(laboratoryRepository, times(1)).findAll();
    }

    @Test
     void testObtenirLaboratoireParId() {
        Long labId = 1L;
        Laboratory laboratory = new Laboratory();
        laboratory.setId(labId);
        
        when(laboratoryRepository.findById(labId)).thenReturn(Optional.of(laboratory));

        Optional<Laboratory> result = laboratoryService.getLaboratoryById(labId);

        assertTrue(result.isPresent());
        assertEquals(labId, result.get().getId());
        verify(laboratoryRepository, times(1)).findById(labId);
    }

    @Test
     void testSupprimerLaboratoire() {
        Long labId = 1L;

        laboratoryService.deleteLaboratory(labId);

        verify(laboratoryRepository, times(1)).deleteById(labId);
    }
}
