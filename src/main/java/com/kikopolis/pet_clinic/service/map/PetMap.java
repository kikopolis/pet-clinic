package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMap extends AbstractMap<Pet, Long> implements PetService {
}
