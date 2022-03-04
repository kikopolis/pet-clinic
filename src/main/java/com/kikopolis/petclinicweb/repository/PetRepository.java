package com.kikopolis.petclinicweb.repository;

import com.kikopolis.petclinicweb.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
