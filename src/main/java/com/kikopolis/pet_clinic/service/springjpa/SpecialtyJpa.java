package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Specialty;
import com.kikopolis.pet_clinic.repository.SpecialtyRepository;
import com.kikopolis.pet_clinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialtyJpa extends AbstractJpa<Specialty, Long, SpecialtyRepository> implements SpecialtyService {
	public SpecialtyJpa(SpecialtyRepository repository) {
		this.repository = repository;
	}
}
