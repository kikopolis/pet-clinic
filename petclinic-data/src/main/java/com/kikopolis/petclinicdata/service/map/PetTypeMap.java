package com.kikopolis.petclinicdata.service.map;

import com.kikopolis.petclinicdata.model.PetType;
import com.kikopolis.petclinicdata.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMap extends AbstractMap<PetType, Long> implements PetTypeService {
}
