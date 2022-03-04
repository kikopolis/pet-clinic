package com.kikopolis.petclinicdata.repository;

import com.kikopolis.petclinicdata.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
