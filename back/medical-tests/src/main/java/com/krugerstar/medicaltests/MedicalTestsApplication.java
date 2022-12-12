package com.krugerstar.medicaltests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.persistence.Entity;

@SpringBootApplication
@EnableDiscoveryClient
public class MedicalTestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalTestsApplication.class, args);
	}

}
