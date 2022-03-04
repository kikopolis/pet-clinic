package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.Visit;
import com.kikopolis.petclinicweb.repository.VisitRepository;
import com.kikopolis.petclinicweb.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitJpa extends AbstractJpa<Visit, Long, VisitRepository> implements VisitService {
	public VisitJpa(VisitRepository repository) {
		this.repository = repository;
	}
}
