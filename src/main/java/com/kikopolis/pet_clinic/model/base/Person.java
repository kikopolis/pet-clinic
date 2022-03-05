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
public abstract class Person extends BaseEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String firstName;
	
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String lastName;
	
	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName  = lastName;
	}
}
