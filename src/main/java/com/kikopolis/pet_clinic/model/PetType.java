package com.kikopolis.pet_clinic.model;

import com.kikopolis.pet_clinic.model.base.NamedEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity {
	@Builder
	public PetType(Long id, String name) {
		super(id, name);
	}
}
