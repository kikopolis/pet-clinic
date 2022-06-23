package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.repository.OwnerRepository;
import com.kikopolis.pet_clinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpa extends AbstractJpa<Owner, Long, OwnerRepository> implements OwnerService {
	public OwnerJpa(OwnerRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Set<Owner> findByLastName(String lastName) {
		return repository.findAllByLastName(lastName);
	}
}
