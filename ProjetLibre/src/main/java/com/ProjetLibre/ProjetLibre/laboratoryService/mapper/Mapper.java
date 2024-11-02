package com.ProjetLibre.ProjetLibre.laboratoryService.mapper;

import com.ProjetLibre.ProjetLibre.laboratoryService.dto.LaboratoryDTO;
import com.ProjetLibre.ProjetLibre.laboratoryService.entity.Laboratory;

public class Mapper {
	
	public Mapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Méthode pour convertir l'entité Laboratory en LaboratoryDTO
    public static LaboratoryDTO toDTO(Laboratory laboratory) {
        if (laboratory == null) {
            return null;
        }
        
        LaboratoryDTO dto = new LaboratoryDTO();
        dto.setId(laboratory.getId());
        dto.setNom(laboratory.getNom());
        dto.setLogo(laboratory.getLogo());
        dto.setNrc(laboratory.getNrc());
        dto.setStatut(laboratory.getStatut());
        dto.setDateActivation(laboratory.getDateActivation());
        
        return dto;
    }

    // Méthode pour convertir LaboratoryDTO en entité Laboratory
    public static Laboratory toEntity(LaboratoryDTO laboratoryDTO) {
        if (laboratoryDTO == null) {
            return null;
        }
        
        Laboratory laboratory = new Laboratory();
        laboratory.setId(laboratoryDTO.getId());
        laboratory.setNom(laboratoryDTO.getNom());
        laboratory.setLogo(laboratoryDTO.getLogo());
        laboratory.setNrc(laboratoryDTO.getNrc());
        laboratory.setStatut(laboratoryDTO.getStatut());
        laboratory.setDateActivation(laboratoryDTO.getDateActivation());
        
        return laboratory;
    }
}
