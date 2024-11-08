package com.example.service_laboratoire.repository;


import com.example.service_laboratoire.entities.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {


}
