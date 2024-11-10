package com.projet_libre.projet_libre.laboratory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.projet_libre.projet_libre.laboratory_service.entity.Laboratory;
@RepositoryRestResource
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {


}
