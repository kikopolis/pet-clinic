package com.kikopolis.petclinicdata.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
	@Column
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name = "pet_type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits;
	
	public Pet() {
		this.visits = new HashSet<>();
	}
	
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public PetType getPetType() {
		return this.petType;
	}
	
	public void setPetType(PetType petType) {
		this.petType = petType;
	}
	
	public Owner getOwner() {
		return this.owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public Set<Visit> getVisits() {
		return this.visits;
	}
	
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}
}
