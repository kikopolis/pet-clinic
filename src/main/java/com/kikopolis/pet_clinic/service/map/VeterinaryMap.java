package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.Specialty;
import com.kikopolis.pet_clinic.model.Veterinary;
import com.kikopolis.pet_clinic.service.SpecialtyService;
import com.kikopolis.pet_clinic.service.VeterinaryService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VeterinaryMap extends AbstractMap<Veterinary, Long> implements VeterinaryService {
	private final SpecialtyService specialtyService;
	
	public VeterinaryMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	@Override
	public Veterinary save(Veterinary object) {
		if (!object.getSpecialties().isEmpty()) {
			object.getSpecialties().forEach(specialty -> {
				if (specialty.getId() == null) {
					Specialty savedSpecialty = this.specialtyService.save(specialty);
					specialty.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
	}
}
