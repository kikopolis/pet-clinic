package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.Specialty;
import com.kikopolis.pet_clinic.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMap extends AbstractMap<Specialty, Long> implements SpecialtyService {
}
