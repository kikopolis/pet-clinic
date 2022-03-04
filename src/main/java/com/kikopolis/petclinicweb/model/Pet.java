package com.kikopolis.petclinicweb.model;

import com.kikopolis.petclinicweb.model.base.NamedEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}
