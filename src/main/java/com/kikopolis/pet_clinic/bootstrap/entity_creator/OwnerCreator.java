package com.kikopolis.pet_clinic.bootstrap.entity_creator;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.model.Visit;
import com.kikopolis.pet_clinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Set;

@Service
public class OwnerCreator extends PersonCreator {
	private final OwnerService ownerService;
	private final PetCreator   petCreator;
	private final VisitCreator visitCreator;
	
	public OwnerCreator(Random random, OwnerService ownerService, PetCreator petLoader, VisitCreator visitCreator) {
		super(random);
		this.ownerService = ownerService;
		this.petCreator   = petLoader;
		this.visitCreator = visitCreator;
	}
	
	public void create(int count) {
		for (int i = 0; i < count; i++) {
			Owner owner = Owner
					.builder()
					.firstName(this.randomFirstName())
					.lastName(this.randomLastName())
					.address(this.randomAddress())
					.city(this.randomCity())
					.telephone(this.randomTelephone())
					.build();
			Owner savedOwner = this.ownerService.save(owner);
			savedOwner.setPets(this.petCreator.fillPets(savedOwner));
			for (Pet pet : savedOwner.getPets()) {
				Set<Visit> visits = this.visitCreator.createVisits(pet);
				pet.setVisits(visits);
			}
		}
	}
}
