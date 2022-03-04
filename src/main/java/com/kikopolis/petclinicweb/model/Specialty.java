package com.kikopolis.petclinicweb.model;

import com.kikopolis.petclinicweb.model.base.NamedEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String description;
}
