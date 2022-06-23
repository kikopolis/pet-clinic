package com.kikopolis.pet_clinic.controller;

import com.kikopolis.pet_clinic.model.Pet;
import com.kikopolis.pet_clinic.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PetControllerUnitTest {
	@Test
	public void petIndexShouldShowAllPets() throws Exception {
		PetService    petService    = Mockito.mock(PetService.class);
		PetController petController = new PetController(petService);
		Set<Pet>      pets          = new HashSet<>();
		pets.add(Pet.builder().id(43L).name("rocky").build());
		pets.add(Pet.builder().build());
		pets.add(Pet.builder().build());
		Mockito.when(petService.findAll()).thenReturn(pets);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
		mockMvc.perform(
				       MockMvcRequestBuilders
						       .get("/pets")
						       .contentType(MediaType.TEXT_HTML_VALUE)
		               )
		       .andExpect(status().isOk())
		       .andExpect(view().name("pet/index"))
		       .andExpect(model().attributeExists("pets"))
		       .andExpect(model().attribute("pets", pets))
		       .andExpect(model().attribute("pets", hasItem(
				       allOf(
						       hasProperty("id", is(43L)),
						       hasProperty("name", is("rocky"))
				            )
		                                                   )));
	}
}
