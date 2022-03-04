package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.Owner;
import com.kikopolis.petclinicweb.repository.OwnerRepository;
import com.kikopolis.petclinicweb.service.OwnerService;
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
