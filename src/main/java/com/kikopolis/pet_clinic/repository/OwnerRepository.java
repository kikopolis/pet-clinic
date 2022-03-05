package com.kikopolis.pet_clinic.repository;

import com.kikopolis.pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastName);
}
