package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.Specialty;
import com.kikopolis.petclinicweb.repository.SpecialtyRepository;
import com.kikopolis.petclinicweb.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyJpa extends AbstractJpa<Specialty, Long, SpecialtyRepository> implements SpecialtyService {
	public SpecialtyJpa(SpecialtyRepository repository) {
		this.repository = repository;
	}
}
