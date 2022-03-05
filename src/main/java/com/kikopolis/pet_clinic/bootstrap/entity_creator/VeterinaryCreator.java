package com.kikopolis.pet_clinic.bootstrap.entity_creator;

import com.kikopolis.pet_clinic.model.Specialty;
import com.kikopolis.pet_clinic.model.Veterinary;
import com.kikopolis.pet_clinic.service.SpecialtyService;
import com.kikopolis.pet_clinic.service.VeterinaryService;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class VeterinaryCreator extends PersonCreator {
	private final VeterinaryService veterinaryService;
	private final SpecialtyService  specialtyService;
	private final Lorem             lorem;
	private final Specialty[]       specialties;
	
	public VeterinaryCreator(Random random, VeterinaryService veterinaryService, SpecialtyService specialtyService) {
		super(random);
		this.veterinaryService = veterinaryService;
		this.specialtyService  = specialtyService;
		this.lorem             = LoremIpsum.getInstance();
		this.specialties       = this.loadSpecialties();
	}
	
	public Set<Specialty> fillSpecialties() {
		Set<Specialty> specialties = new HashSet<>();
		for (int i = 0; i < this.random.nextInt(1, 3); i++) {
			specialties.add(this.specialties[this.random.nextInt(0, 4)]);
		}
		return specialties;
	}
	
	public void create(int count) {
		for (int i = 0; i < count; i++) {
			Veterinary veterinary = Veterinary
					.builder()
					.firstName(this.randomFirstName())
					.lastName(this.randomLastName())
					.specialties(this.fillSpecialties())
					.build();
			this.veterinaryService.save(veterinary);
		}
	}
	
	private Specialty[] loadSpecialties() {
		String[]       specs       = new String[]{"surgery", "radiology", "dentistry", "beautician"};
		Set<Specialty> specialties = new HashSet<>();
		for (String s : specs) {
			Specialty specialty = Specialty
					.builder()
					.name(s)
					.description(this.lorem.getWords(5, 15))
					.build();
			specialties.add(this.specialtyService.save(specialty));
		}
		return specialties.toArray(new Specialty[4]);
	}
}
