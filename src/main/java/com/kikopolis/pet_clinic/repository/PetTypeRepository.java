package com.kikopolis.pet_clinic.repository;

import com.kikopolis.pet_clinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
