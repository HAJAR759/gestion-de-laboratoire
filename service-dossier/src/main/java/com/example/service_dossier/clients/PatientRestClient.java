package com.example.service_dossier.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service_dossier.model.Patient;

@FeignClient(name="service-patient")
public interface PatientRestClient {
	@GetMapping("/patients")
    List<Patient> findAllPatients();
}
