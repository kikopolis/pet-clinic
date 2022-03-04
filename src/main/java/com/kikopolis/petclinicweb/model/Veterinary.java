package com.kikopolis.petclinicweb.model;

import com.kikopolis.petclinicweb.model.base.Person;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "veterinaries")
public class Veterinary extends Person {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "veterinary_specialties",
			joinColumns = @JoinColumn(name = "veterinary_id"),
			inverseJoinColumns = @JoinColumn(name = "specialty_id"))
	@NonNull
	private Set<Specialty> specialties;
}
