package com.kikopolis.petclinicdata.service.map;

import com.kikopolis.petclinicdata.model.Owner;
import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.model.Visit;
import com.kikopolis.petclinicdata.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMap extends AbstractMap<Visit, Long> implements VisitService {
	@Override
	public Visit save(Visit visit) {
		Pet   pet   = visit.getPet();
		Owner owner = pet.getOwner();
		if (pet == null || owner == null || pet.getId() == null || owner.getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(visit);
	}
}
