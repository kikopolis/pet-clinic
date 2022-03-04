package com.kikopolis.petclinicweb.service.map;

import com.kikopolis.petclinicweb.model.Pet;
import com.kikopolis.petclinicweb.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMap extends AbstractMap<Pet, Long> implements PetService {
}
