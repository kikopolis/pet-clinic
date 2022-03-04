package com.kikopolis.petclinicdata.service.map;

import com.kikopolis.petclinicdata.model.Specialty;
import com.kikopolis.petclinicdata.service.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyMap extends AbstractMap<Specialty, Long> implements SpecialtyService {
}
