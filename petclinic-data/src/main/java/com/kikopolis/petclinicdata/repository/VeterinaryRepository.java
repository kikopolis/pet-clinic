package com.kikopolis.petclinicdata.repository;

import com.kikopolis.petclinicdata.model.Veterinary;
import org.springframework.data.repository.CrudRepository;

public interface VeterinaryRepository extends CrudRepository<Veterinary, Long> {
}
