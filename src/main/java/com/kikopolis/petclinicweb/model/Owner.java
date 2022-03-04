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
}
