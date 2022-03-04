package com.kikopolis.petclinicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kikopolis.petclinicweb", "com.kikopolis.petclinicdata"})
public class PetClinicApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}
	
}
