package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.repository.OwnerRepository;
import com.kikopolis.pet_clinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerJpa extends AbstractJpa<Owner, Long, OwnerRepository> implements OwnerService {
	public OwnerJpa(OwnerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Owner findByLastName(String lastName) {
		return this.repository.findByLastName(lastName);
	}
}
