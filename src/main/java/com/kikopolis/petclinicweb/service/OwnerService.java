package com.kikopolis.petclinicweb.service;

import com.kikopolis.petclinicweb.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
