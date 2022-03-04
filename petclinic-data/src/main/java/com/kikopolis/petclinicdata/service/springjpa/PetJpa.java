package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.repository.PetRepository;
import com.kikopolis.petclinicdata.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetJpa extends AbstractJpa<Pet, Long, PetRepository> implements PetService {
	public PetJpa(PetRepository repository) {
		this.repository = repository;
	}
}
