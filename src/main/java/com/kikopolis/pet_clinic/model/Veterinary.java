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
@Table(name = "veterinaries")
public class Veterinary extends Person {
	@Builder
	public Veterinary(Long id, String firstName, String lastName, Set<Specialty> specialties) {
		super(id, firstName, lastName);
		if (specialties != null) {
			this.specialties = specialties;
		} else {
			this.specialties = new HashSet<>();
		}
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "veterinary_specialties",
			joinColumns = @JoinColumn(name = "veterinary_id"),
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	@NonNull
	private Set<Specialty> specialties;
}
