package com.kikopolis.pet_clinic.bootstrap.entity_creator;

import com.kikopolis.pet_clinic.bootstrap.help.Date;
import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.service.PetService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class PetCreator {
	private final String[]       names;
	private final Random         random;
	private final PetTypeCreator petTypeCreator;
	private final PetService     petService;
	private final Date           date;
	
	public PetCreator(Random random, PetTypeCreator petTypeCreator, PetService petService, Date date) {
		this.random         = random;
		this.petTypeCreator = petTypeCreator;
		this.petService     = petService;
		this.date           = date;
		this.names          = this.names();
	}
	
	public Set<Pet> fillPets(Owner owner) {
		Set<Pet> pets = new HashSet<>();
		for (int j = 0; j < this.random.nextInt(1, 3); j++) {
			pets.add(this.createPet(owner));
		}
		return pets;
	}
	
	private Pet createPet(Owner owner) {
		Pet pet = Pet
				.builder()
				.owner(owner)
				.name(this.getRandomName())
				.petType(this.petTypeCreator.getRandomType())
				.birthDate(this.date.between(LocalDate.of(2015, 1, 1), LocalDate.now()))
				.build();
		pet.setOwner(owner);
		pet.setName(this.getRandomName());
		pet.setPetType(this.petTypeCreator.getRandomType());
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
