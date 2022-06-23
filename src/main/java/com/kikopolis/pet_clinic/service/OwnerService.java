package com.kikopolis.pet_clinic.service;

import com.kikopolis.pet_clinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
	Set<Owner> findByLastName(String lastName);
}
