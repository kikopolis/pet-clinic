package com.kikopolis.petclinicweb.service.map;

import com.kikopolis.petclinicweb.model.Pet;
import com.kikopolis.petclinicweb.model.Visit;
import com.kikopolis.petclinicweb.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMap extends AbstractMap<Visit, Long> implements VisitService {
	@Override
	public Visit save(Visit visit) {
		Pet pet = visit.getPet();
		if (visit.getPet() == null || pet.getOwner() == null || pet.getId() == null || pet.getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(visit);
	}
}
