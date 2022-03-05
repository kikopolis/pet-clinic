package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Visit;
import com.kikopolis.pet_clinic.repository.VisitRepository;
import com.kikopolis.pet_clinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitJpa extends AbstractJpa<Visit, Long, VisitRepository> implements VisitService {
	public VisitJpa(VisitRepository repository) {
		this.repository = repository;
	}
}
