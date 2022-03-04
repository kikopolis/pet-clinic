package com.kikopolis.petclinicweb.model;

import com.kikopolis.petclinicweb.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private LocalDate date;
	
	@Column(nullable = false)
	@NonNull
	@ToString.Include
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "pet_id", nullable = false)
	@NonNull
	private Pet pet;
}
