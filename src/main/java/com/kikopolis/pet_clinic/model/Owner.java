package com.kikopolis.pet_clinic.model;

import com.kikopolis.pet_clinic.model.base.Person;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "owners")
public class Owner extends Person {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String address;
	
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String city;
	
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@NonNull
	private Set<Pet> pets;
	
	@Builder
	public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
		super(id, firstName, lastName);
		this.address   = address;
		this.city      = city;
		this.telephone = telephone;
		if (pets != null) {
			this.pets = pets;
		} else {
			this.pets = new HashSet<>();
		}
	}
}
