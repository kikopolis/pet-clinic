package com.kikopolis.petclinicweb.repository;

import com.kikopolis.petclinicweb.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
