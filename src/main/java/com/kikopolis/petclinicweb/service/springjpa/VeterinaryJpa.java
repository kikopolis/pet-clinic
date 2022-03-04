package com.kikopolis.petclinicweb.service.springjpa;

import com.kikopolis.petclinicweb.model.Veterinary;
import com.kikopolis.petclinicweb.repository.VeterinaryRepository;
import com.kikopolis.petclinicweb.service.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VeterinaryJpa extends AbstractJpa<Veterinary, Long, VeterinaryRepository> implements VeterinaryService {
	public VeterinaryJpa(VeterinaryRepository repository) {
		this.repository = repository;
	}
}
