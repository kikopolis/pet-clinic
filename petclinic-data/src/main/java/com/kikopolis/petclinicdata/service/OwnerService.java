package com.kikopolis.petclinicdata.service;

import com.kikopolis.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
