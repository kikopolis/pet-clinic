package com.kikopolis.pet_clinic.repository;

import com.kikopolis.pet_clinic.model.Veterinary;
import org.springframework.data.repository.CrudRepository;

public interface VeterinaryRepository extends CrudRepository<Veterinary, Long> {
}
