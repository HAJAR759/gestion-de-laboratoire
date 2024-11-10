package com.projet_libre.projet_libre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ProjetLibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetLibreApplication.class, args);
	}

}
