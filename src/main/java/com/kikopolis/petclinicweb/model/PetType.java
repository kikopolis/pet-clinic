package com.kikopolis.petclinicweb.model;

import com.kikopolis.petclinicweb.model.base.NamedEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {
}
