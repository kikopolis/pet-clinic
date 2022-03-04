package com.kikopolis.petclinicdata.service.map;

import com.kikopolis.petclinicdata.model.Pet;
import com.kikopolis.petclinicdata.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMap extends AbstractMap<Pet, Long> implements PetService {
}
