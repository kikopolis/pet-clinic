package com.kikopolis.petclinicdata.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {
}
