package com.kikopolis.petclinicweb.service.map;

import com.kikopolis.petclinicweb.model.Specialty;
import com.kikopolis.petclinicweb.service.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialtyMap extends AbstractMap<Specialty, Long> implements SpecialtyService {
}
