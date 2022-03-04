package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.PetType;
import com.kikopolis.petclinicweb.repository.PetTypeRepository;
import com.kikopolis.petclinicweb.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeJpa extends AbstractJpa<PetType, Long, PetTypeRepository> implements PetTypeService {
	public PetTypeJpa(PetTypeRepository repository) {
		this.repository = repository;
	}
}
