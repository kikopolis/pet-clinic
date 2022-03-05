package com.kikopolis.pet_clinic.service;

import com.kikopolis.pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
