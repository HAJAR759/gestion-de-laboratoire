package com.example.service_dossier.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service_dossier.model.Utilisateur;


@FeignClient(name="service-utilisateur")
public interface UtilisateurRestClient {
	@GetMapping("/users")
    List<Utilisateur> findAllUsers();
}
