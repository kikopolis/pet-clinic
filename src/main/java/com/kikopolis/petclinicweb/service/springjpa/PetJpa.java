package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.Pet;
import com.kikopolis.petclinicweb.repository.PetRepository;
import com.kikopolis.petclinicweb.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetJpa extends AbstractJpa<Pet, Long, PetRepository> implements PetService {
	public PetJpa(PetRepository repository) {
		this.repository = repository;
	}
}
