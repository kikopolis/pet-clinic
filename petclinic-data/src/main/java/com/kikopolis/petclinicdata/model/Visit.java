package com.kikopolis.petclinicdata.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Column(nullable = false)
	private LocalDate date;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Pet getPet() {
		return this.pet;
	}
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
