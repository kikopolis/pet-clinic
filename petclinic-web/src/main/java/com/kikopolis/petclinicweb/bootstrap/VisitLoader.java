package com.kikopolis.petclinicweb.bootstrap;

import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.model.Visit;
import com.kikopolis.petclinicdata.service.VisitService;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VisitLoader {
	private final VisitService visitService;
	private final Random       random;
	private final Lorem        lorem;
	
	public VisitLoader(VisitService visitService, Random random) {
		this.visitService = visitService;
		this.random       = random;
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
		Visit visit = new Visit();
		visit.setPet(pet);
		visit.setDescription(this.lorem.getWords(10, 25));
		visit.setDate(this.between(LocalDate.now(), LocalDate.of(2022, 12, 22)));
		return this.visitService.save(visit);
	}
	
	private LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
		long startEpochDay = startInclusive.toEpochDay();
		long endEpochDay   = endExclusive.toEpochDay();
		long randomDay = ThreadLocalRandom
				.current()
				.nextLong(startEpochDay, endEpochDay);
		
		return LocalDate.ofEpochDay(randomDay);
	}
}
