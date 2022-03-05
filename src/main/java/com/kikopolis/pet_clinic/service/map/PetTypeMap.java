package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.PetType;
import com.kikopolis.pet_clinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMap extends AbstractMap<PetType, Long> implements PetTypeService {
}
