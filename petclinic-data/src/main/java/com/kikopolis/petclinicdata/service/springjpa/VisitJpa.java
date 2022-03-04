package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.Visit;
import com.kikopolis.petclinicdata.repository.VisitRepository;
import com.kikopolis.petclinicdata.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitJpa extends AbstractJpa<Visit, Long, VisitRepository> implements VisitService {
	public VisitJpa(VisitRepository repository) {
		this.repository = repository;
	}
}
