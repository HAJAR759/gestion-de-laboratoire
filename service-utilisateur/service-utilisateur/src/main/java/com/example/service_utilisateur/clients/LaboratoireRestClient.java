package com.example.service_utilisateur.clients;

import com.example.service_utilisateur.model.Laboratoire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ProjetLibre")
public interface LaboratoireRestClient {
    @GetMapping("/laboratoi")
    List<Laboratoire> findAllLaboratoires();

}
