package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.repository.PetRepository;
import com.kikopolis.pet_clinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetJpa extends AbstractJpa<Pet, Long, PetRepository> implements PetService {
	public PetJpa(PetRepository repository) {
		this.repository = repository;
	}
}
