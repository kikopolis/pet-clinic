package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.Specialty;
import com.kikopolis.petclinicdata.repository.SpecialtyRepository;
import com.kikopolis.petclinicdata.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyJpa extends AbstractJpa<Specialty, Long, SpecialtyRepository> implements SpecialtyService {
	public SpecialtyJpa(SpecialtyRepository repository) {
		this.repository = repository;
	}
}
