package com.kikopolis.petclinicweb.bootstrap;

import com.kikopolis.petclinicweb.model.Specialty;
import com.kikopolis.petclinicweb.service.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class VeterinaryLoader extends PersonLoader {
	private final SpecialtyService specialtyService;
	private final Specialty[]      specialties;
	
	public VeterinaryLoader(Random random, SpecialtyService specialtyService) {
		super(random);
		this.specialtyService = specialtyService;
		this.specialties      = this.loadSpecialties();
	}
	
	public Set<Specialty> fillSpecialties() {
		Set<Specialty> specialties = new HashSet<>();
		for (int i = 0; i < this.random.nextInt(1, 3); i++) {
			specialties.add(this.specialties[this.random.nextInt(0, 4)]);
		}
		return specialties;
	}
	
	private Specialty[] loadSpecialties() {
		String[]       specs       = new String[]{"surgery", "radiology", "dentistry", "beautician"};
		Set<Specialty> specialties = new HashSet<>();
		for (String s : specs) {
			Specialty specialty = new Specialty();
			specialty.setName(s);
			specialty.setDescription(s);
			specialties.add(this.specialtyService.save(specialty));
		}
		return specialties.toArray(new Specialty[4]);
	}
}
