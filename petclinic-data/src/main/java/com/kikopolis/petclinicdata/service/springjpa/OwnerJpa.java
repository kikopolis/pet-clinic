package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.Owner;
import com.kikopolis.petclinicdata.repository.OwnerRepository;
import com.kikopolis.petclinicdata.service.OwnerService;
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
