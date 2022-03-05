package com.kikopolis.pet_clinic.bootstrap.entity_creator;

import com.kikopolis.pet_clinic.bootstrap.help.Date;
import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.model.Visit;
import com.kikopolis.pet_clinic.service.VisitService;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class VisitCreator {
	private final VisitService visitService;
	private final Random       random;
	private final Date         date;
	private final Lorem        lorem;
	
	public VisitCreator(VisitService visitService, Random random, Date date) {
		this.visitService = visitService;
		this.random       = random;
		this.date         = date;
		this.lorem        = LoremIpsum.getInstance();
	}
	
	public Set<Visit> createVisits(Pet pet) {
		Set<Visit> visits = new HashSet<>();
		for (int i = 0; i < this.random.nextInt(1, 4); i++) {
			visits.add(this.createVisit(pet));
		}
		return visits;
	}
	
	private Visit createVisit(Pet pet) {
		Visit visit = Visit
				.builder()
				.pet(pet)
				.description(this.lorem.getWords(3, 9))
				.date(this.date.between(LocalDate.now(), LocalDate.of(2022, 12, 22)))
				.build();
		return this.visitService.save(visit);
	}
}
