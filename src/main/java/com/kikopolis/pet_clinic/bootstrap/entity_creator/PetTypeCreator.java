package com.kikopolis.pet_clinic.bootstrap.entity_creator;

import com.kikopolis.pet_clinic.model.PetType;
import com.kikopolis.pet_clinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PetTypeCreator {
	private final String[]       types;
	private final Random         random;
	private final PetTypeService petTypeService;
	private       List<PetType>  savedPetTypes;
	
	public PetTypeCreator(Random random, PetTypeService petTypeService) {
		this.random         = random;
		this.petTypeService = petTypeService;
		this.types          = new String[]{"Dog", "Cat", "Hamster", "Guinea pig", "Parrot", "Rabbit", "Snake", "Frog"};
		this.savePetTypes();
	}
	
	public PetType getRandomType() {
		return this.savedPetTypes.get(this.random.nextInt(0, this.types.length));
	}
	
	private void savePetTypes() {
		this.savedPetTypes = new ArrayList<>();
		for (String type : this.types) {
			PetType petType = PetType.builder().name(type).build();
			this.savedPetTypes.add(this.petTypeService.save(petType));
		}
	}
}
