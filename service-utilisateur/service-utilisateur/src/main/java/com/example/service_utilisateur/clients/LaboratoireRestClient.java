package com.example.service_utilisateur.clients;

import com.example.service_utilisateur.model.Laboratory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ProjetLibre")
public interface LaboratoireRestClient {
    @GetMapping("/laboratoi")
    List<Laboratory> findAllLaboratoires();

}
