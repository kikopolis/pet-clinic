package com.kikopolis.petclinicweb.repository;

import com.kikopolis.petclinicweb.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
