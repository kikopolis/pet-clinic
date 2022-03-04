package com.kikopolis.petclinicdata.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "veterinaries")
public class Veterinary extends Person {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "veterinary_specialties",
			joinColumns = @JoinColumn(name = "veterinary_id"),
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	private Set<Specialty> specialties;
	
	public Veterinary() {
		this.specialties = new HashSet<>();
	}
	
	public Set<Specialty> getSpecialties() {
		return this.specialties;
	}
	
	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
}
