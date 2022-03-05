package com.kikopolis.pet_clinic.model.base;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String name;
	
	public NamedEntity(Long id, String name) {
		super(id);
		this.name = name;
	}
}
