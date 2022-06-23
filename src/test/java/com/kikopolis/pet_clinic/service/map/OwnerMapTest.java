package com.kikopolis.pet_clinic.service.map;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.model.PetType;
import com.kikopolis.pet_clinic.service.PetService;
import com.kikopolis.pet_clinic.service.PetTypeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class OwnerMapTest {
	
	@Test
	public void find() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner          = Owner.builder().firstName("sam").id(221L).build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		ownerMap.save(owner);
		Owner foundOwner = ownerMap.find(221L);
		Assertions.assertEquals("sam", foundOwner.getFirstName());
	}
	
	@Test
	public void findAll() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner1         = Owner.builder().firstName("sam").build();
		Owner          owner2         = Owner.builder().firstName("bam").build();
		Owner          owner3         = Owner.builder().firstName("rocky").build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		ownerMap.save(owner1);
		ownerMap.save(owner2);
		ownerMap.save(owner3);
		Set<Owner> owners = ownerMap.findAll();
		Assertions.assertEquals(3, owners.size());
	}
	
	@Test
	public void delete() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner1         = Owner.builder().firstName("sam").build();
		Owner          owner2         = Owner.builder().firstName("bam").build();
		Owner          owner3         = Owner.builder().firstName("rocky").build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		ownerMap.save(owner1);
		ownerMap.save(owner2);
		ownerMap.save(owner3);
		ownerMap.delete(owner1);
		Set<Owner> owners = ownerMap.findAll();
		Assertions.assertEquals(2, owners.size());
		Assertions.assertFalse(owners.contains(owner1));
	}
	
	@Test
	public void deleteById() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner1         = Owner.builder().id(221L).firstName("sam").build();
		Owner          owner2         = Owner.builder().firstName("bam").build();
		Owner          owner3         = Owner.builder().firstName("rocky").build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		ownerMap.save(owner1);
		ownerMap.save(owner2);
		ownerMap.save(owner3);
		ownerMap.deleteById(221L);
		Set<Owner> owners = ownerMap.findAll();
		Assertions.assertEquals(2, owners.size());
		Assertions.assertFalse(owners.contains(owner1));
	}
	
	@Test
	public void findByLastName() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner1         = Owner.builder().firstName("sam").lastName("well").build();
		Owner          owner2         = Owner.builder().firstName("bucky").lastName("well").build();
		Owner          owner3         = Owner.builder().firstName("bucky").lastName("nuts").build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		ownerMap.save(owner1);
		ownerMap.save(owner2);
		ownerMap.save(owner3);
		Set<Owner> foundOwners = ownerMap.findByLastName("well");
		Assertions.assertEquals(2, foundOwners.size());
		Assertions.assertFalse(foundOwners.contains(owner3));
	}
	
	@Test
	public void saveOwnerWithoutPets() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner          = Owner.builder().id(143L).build();
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		Owner          savedOwner     = ownerMap.save(owner);
		Assertions.assertNotNull(savedOwner);
		Assertions.assertEquals(143L, savedOwner.getId());
	}
	
	@Test
	public void saveOwnerWithPetButPetDoesNotHaveOwner() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		PetType        petType        = Mockito.mock(PetType.class);
		Owner          owner          = Mockito.mock(Owner.class);
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		Pet            pet            = Pet.builder().name("bucky").birthDate(LocalDate.now()).petType(petType).build();
		Set<Pet>       pets           = new HashSet<>();
		pets.add(pet);
		Mockito.when(owner.getPets()).thenReturn(pets);
		Mockito.when(petService.save(pet)).thenReturn(pet);
		Owner savedOwner = ownerMap.save(owner);
		Assertions.assertNotNull(savedOwner);
		Assertions.assertTrue(owner.getPets().contains(pet));
	}
	
	@Test
	public void saveOwnerWithPetButPetDoesNotHavePetType() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		Owner          owner          = Mockito.mock(Owner.class);
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		Pet            pet            = Pet.builder().name("bucky").birthDate(LocalDate.now()).build();
		Set<Pet>       pets           = new HashSet<>();
		pets.add(pet);
		Mockito.when(owner.getPets()).thenReturn(pets);
		Mockito.when(petService.save(pet)).thenReturn(pet);
		Assertions.assertThrowsExactly(RuntimeException.class, () -> ownerMap.save(owner));
	}
	
	@Test
	public void saveOwnerWithPetButPetDoesNotHavePetTypeSaved() {
		PetService     petService     = Mockito.mock(PetService.class);
		PetTypeService petTypeService = Mockito.mock(PetTypeService.class);
		PetType        petType        = Mockito.mock(PetType.class);
		Owner          owner          = Mockito.mock(Owner.class);
		OwnerMap       ownerMap       = new OwnerMap(petTypeService, petService);
		Pet            pet            = Pet.builder().name("bucky").birthDate(LocalDate.now()).petType(petType).build();
		Set<Pet>       pets           = new HashSet<>();
		pets.add(pet);
		Mockito.when(owner.getPets()).thenReturn(pets);
		Mockito.when(petService.save(pet)).thenReturn(pet);
		Mockito.when(petType.getId()).thenReturn(null);
		Mockito.when(petTypeService.save(petType)).thenReturn(petType);
		Owner savedOwner = ownerMap.save(owner);
		Assertions.assertNotNull(savedOwner);
		Assertions.assertTrue(owner.getPets().contains(pet));
	}
}