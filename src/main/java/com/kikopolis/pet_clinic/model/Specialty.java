package com.kikopolis.pet_clinic.model;

import com.kikopolis.pet_clinic.model.base.NamedEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String description;
	
	@Builder
	public Specialty(Long id, String name, String description) {
		super(id, name);
		this.description = description;
	}
}
