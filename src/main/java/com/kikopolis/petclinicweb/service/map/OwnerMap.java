package com.kikopolis.petclinicweb.service.map;

import com.kikopolis.petclinicweb.model.Owner;
import com.kikopolis.petclinicweb.model.Pet;
import com.kikopolis.petclinicweb.service.OwnerService;
import com.kikopolis.petclinicweb.service.PetService;
import com.kikopolis.petclinicweb.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

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
	public Owner findByLastName(String lastName) {
		return null;
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
