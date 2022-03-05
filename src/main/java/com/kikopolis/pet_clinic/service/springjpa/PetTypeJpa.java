package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.PetType;
import com.kikopolis.pet_clinic.repository.PetTypeRepository;
import com.kikopolis.pet_clinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeJpa extends AbstractJpa<PetType, Long, PetTypeRepository> implements PetTypeService {
	public PetTypeJpa(PetTypeRepository repository) {
		this.repository = repository;
	}
}
