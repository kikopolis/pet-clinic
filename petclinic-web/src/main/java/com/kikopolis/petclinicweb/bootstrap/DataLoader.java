package com.kikopolis.petclinicweb.bootstrap;

import com.kikopolis.petclinicdata.model.Owner;
import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.model.Veterinary;
import com.kikopolis.petclinicdata.model.Visit;
import com.kikopolis.petclinicdata.service.OwnerService;
import com.kikopolis.petclinicdata.service.VeterinaryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerService      ownerService;
	private final OwnerLoader       ownerLoader;
	private final PetLoader         petLoader;
	private final VeterinaryService veterinaryService;
	private final VeterinaryLoader  veterinaryLoader;
	private final VisitLoader       visitLoader;
	
	public DataLoader(
			OwnerService ownerService,
			OwnerLoader ownerLoader,
			PetLoader petLoader,
			VeterinaryService veterinaryService,
			VeterinaryLoader veterinaryLoader,
			VisitLoader visitLoader
	                 ) {
		this.ownerService      = ownerService;
		this.ownerLoader       = ownerLoader;
		this.petLoader         = petLoader;
		this.veterinaryService = veterinaryService;
		this.veterinaryLoader  = veterinaryLoader;
		this.visitLoader       = visitLoader;
	}
	
	@Override
	public void run(String... args) {
		this.loadOwners();
		this.loadVeterinaries();
	}
	
	private void loadOwners() {
		for (int i = 0; i < 15; i++) {
			Owner owner = new Owner();
			owner.setFirstName(this.ownerLoader.randomFirstName());
			owner.setLastName(this.ownerLoader.randomLastName());
			owner.setAddress(this.ownerLoader.randomAddress());
			owner.setCity(this.ownerLoader.randomCity());
			owner.setTelephone(this.ownerLoader.randomTelephone());
			owner.setPets(this.petLoader.fillPets());
			Owner savedOwner = this.ownerService.save(owner);
			for (Pet pet : savedOwner.getPets()) {
				Set<Visit> visits = this.visitLoader.createVisits(pet);
				pet.setVisits(visits);
			}
		}
	}
	
	private void loadVeterinaries() {
		for (int i = 0; i < 8; i++) {
			Veterinary veterinary = new Veterinary();
			veterinary.setFirstName(this.veterinaryLoader.randomFirstName());
			veterinary.setLastName(this.veterinaryLoader.randomLastName());
			veterinary.setSpecialties(this.veterinaryLoader.fillSpecialties());
			this.veterinaryService.save(veterinary);
		}
	}
}
