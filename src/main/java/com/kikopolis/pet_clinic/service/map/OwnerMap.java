package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.service.OwnerService;
import com.kikopolis.pet_clinic.service.PetService;
import com.kikopolis.pet_clinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMap extends AbstractMap<Owner, Long> implements OwnerService {
	private final PetTypeService petTypeService;
	private final PetService     petService;
	
	public OwnerMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService     = petService;
	}
	
	@Override
	public Set<Owner> findByLastName(String lastName) {
		Set<Owner> owners = new HashSet<>();
		for (Owner owner : this.map.values()) {
			if (lastName.equals(owner.getLastName())) {
				owners.add(owner);
			}
		}
		return owners;
	}
	
	@Override
	public Owner save(Owner object) {
		if (object == null) {
			return null;
		}
		if (object.getPets() != null) {
			object.getPets().forEach(pet -> {
				if (pet.getOwner() == null) {
					pet.setOwner(object);
				}
				if (pet.getPetType() != null) {
					if (pet.getPetType().getId() == null) {
						pet.setPetType(this.petTypeService.save(pet.getPetType()));
					}
				} else {
					throw new RuntimeException("Pet Type is REQUIRED");
				}
				if (pet.getId() == null) {
					Pet savedPet = this.petService.save(pet);
					pet.setId(savedPet.getId());
				}
			});
		}
		return super.save(object);
	}
}
