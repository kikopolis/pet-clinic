package com.kikopolis.pet_clinic.bootstrap;

import com.kikopolis.pet_clinic.bootstrap.entity_creator.OwnerCreator;
import com.kikopolis.pet_clinic.bootstrap.entity_creator.VeterinaryCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	private final OwnerCreator      ownerCreator;
	private final VeterinaryCreator veterinaryCreator;
	
	public DataLoader(OwnerCreator ownerLoader, VeterinaryCreator veterinaryLoader) {
		this.ownerCreator      = ownerLoader;
		this.veterinaryCreator = veterinaryLoader;
	}
	
	@Override
	public void run(String... args) {
		this.ownerCreator.create(15);
		this.veterinaryCreator.create(8);
	}
}
