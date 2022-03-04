package com.kikopolis.petclinicdata.repository;

import com.kikopolis.petclinicdata.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
