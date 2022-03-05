package com.kikopolis.pet_clinic.service.springjpa;

import com.kikopolis.pet_clinic.model.Veterinary;
import com.kikopolis.pet_clinic.repository.VeterinaryRepository;
import com.kikopolis.pet_clinic.service.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VeterinaryJpa extends AbstractJpa<Veterinary, Long, VeterinaryRepository> implements VeterinaryService {
	public VeterinaryJpa(VeterinaryRepository repository) {
		this.repository = repository;
	}
}
