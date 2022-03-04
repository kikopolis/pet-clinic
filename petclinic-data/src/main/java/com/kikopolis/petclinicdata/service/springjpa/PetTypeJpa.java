package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.PetType;
import com.kikopolis.petclinicdata.repository.PetTypeRepository;
import com.kikopolis.petclinicdata.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeJpa extends AbstractJpa<PetType, Long, PetTypeRepository> implements PetTypeService {
	public PetTypeJpa(PetTypeRepository repository) {
		this.repository = repository;
	}
}
