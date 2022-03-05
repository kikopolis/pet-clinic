package com.kikopolis.pet_clinic.model;

import com.kikopolis.pet_clinic.model.base.NamedEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private LocalDate birthDate;
	
	@ManyToOne
	@JoinColumn(name = "pet_type_id", nullable = false)
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private Owner owner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits;
	
	@Builder
	public Pet(Long id, String name, LocalDate birthDate, PetType petType, Owner owner, Set<Visit> visits) {
		super(id, name);
		this.birthDate = birthDate;
		this.petType   = petType;
		this.owner     = owner;
		if (visits != null) {
			this.visits = visits;
		} else {
			this.visits = new HashSet<>();
		}
	}
}
