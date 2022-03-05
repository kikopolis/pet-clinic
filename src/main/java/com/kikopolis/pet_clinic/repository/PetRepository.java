package com.kikopolis.pet_clinic.repository;

import com.kikopolis.pet_clinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
