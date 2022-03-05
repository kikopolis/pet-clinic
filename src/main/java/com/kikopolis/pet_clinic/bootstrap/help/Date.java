package com.kikopolis.pet_clinic.bootstrap.help;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class Date {
	public LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
		long startEpochDay = startInclusive.toEpochDay();
		long endEpochDay   = endExclusive.toEpochDay();
		long randomDay = ThreadLocalRandom
				.current()
				.nextLong(startEpochDay, endEpochDay);
		
		return LocalDate.ofEpochDay(randomDay);
	}
}
