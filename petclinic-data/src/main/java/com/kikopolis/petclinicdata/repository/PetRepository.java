package com.kikopolis.petclinicdata.repository;

import com.kikopolis.petclinicdata.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
