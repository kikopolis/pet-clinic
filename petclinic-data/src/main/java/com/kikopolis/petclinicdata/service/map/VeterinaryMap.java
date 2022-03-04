package com.kikopolis.petclinicdata.service.map;

import com.kikopolis.petclinicdata.model.Specialty;
import com.kikopolis.petclinicdata.model.Veterinary;
import com.kikopolis.petclinicdata.service.SpecialtyService;
import com.kikopolis.petclinicdata.service.VeterinaryService;
import org.springframework.stereotype.Service;

@Service
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
