package com.kikopolis.petclinicweb.bootstrap;

import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.model.Visit;
import com.kikopolis.petclinicdata.service.PetService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class PetLoader {
	private final String[]      names;
	private final Random        random;
	private final PetTypeLoader petTypeLoader;
	private final PetService    petService;
	
	public PetLoader(
			Random random,
			PetTypeLoader petTypeLoader,
			PetService petService
	                ) {
		this.random        = random;
		this.petTypeLoader = petTypeLoader;
		this.petService    = petService;
		this.names         = this.names();
	}
	
	public Set<Pet> fillPets() {
		Set<Pet> pets = new HashSet<>();
		for (int j = 0; j < this.random.nextInt(1, 3); j++) {
			pets.add(this.createPet());
		}
		return pets;
	}
	
	private Pet createPet() {
		Pet pet = new Pet();
		pet.setName(this.getRandomName());
		pet.setPetType(this.petTypeLoader.getRandomType());
		pet.setBirthDate(LocalDate.now());
		return this.petService.save(pet);
	}
	
	private String getRandomName() {
		return this.names[this.random.nextInt(0, this.names.length)];
	}
	
	private String[] names() {
		return new String[]{
				"Max",
				"Milo",
				"Rocky",
				"Bear",
				"Lily",
				"Grogu",
				"Ace",
				"Wally",
				"Woofie",
				"Sly",
				"Lassie",
				"Buster",
				"Zorro",
				"Tiny",
		};
	}
}
