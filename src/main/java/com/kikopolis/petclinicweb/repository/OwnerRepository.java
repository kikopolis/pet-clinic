package com.kikopolis.petclinicweb.repository;

import com.kikopolis.petclinicweb.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastName);
}
