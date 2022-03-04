package com.kikopolis.petclinicdata.repository;

import com.kikopolis.petclinicdata.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
