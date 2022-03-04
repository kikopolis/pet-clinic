package com.kikopolis.petclinicweb.service.map;

import com.kikopolis.petclinicweb.model.PetType;
import com.kikopolis.petclinicweb.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMap extends AbstractMap<PetType, Long> implements PetTypeService {
}
