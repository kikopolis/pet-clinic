package com.kikopolis.petclinicdata.service.springjpa;

import com.kikopolis.petclinicdata.model.Veterinary;
import com.kikopolis.petclinicdata.repository.VeterinaryRepository;
import com.kikopolis.petclinicdata.service.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VeterinaryJpa extends AbstractJpa<Veterinary, Long, VeterinaryRepository> implements VeterinaryService {
	public VeterinaryJpa(VeterinaryRepository repository) {
		this.repository = repository;
	}
}
