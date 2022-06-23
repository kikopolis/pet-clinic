package com.kikopolis.pet_clinic.repository;

import com.kikopolis.pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Set<Owner> findAllByLastName(String lastName);
}
