package com.kikopolis.petclinicweb.model.base;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

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
}
