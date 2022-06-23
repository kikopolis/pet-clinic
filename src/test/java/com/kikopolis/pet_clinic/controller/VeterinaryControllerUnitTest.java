package com.kikopolis.pet_clinic.controller;

import com.kikopolis.pet_clinic.model.Veterinary;
import com.kikopolis.pet_clinic.service.VeterinaryService;
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

public class VeterinaryControllerUnitTest {
	@Test
	public void veterinaryIndexShouldShowAllVeterinaries() throws Exception {
		VeterinaryService    veterinaryService    = Mockito.mock(VeterinaryService.class);
		VeterinaryController veterinaryController = new VeterinaryController(veterinaryService);
		Set<Veterinary>      veterinaries         = new HashSet<>();
		veterinaries.add(Veterinary.builder().id(43L).firstName("vet").lastName("rinart").build());
		veterinaries.add(Veterinary.builder().build());
		veterinaries.add(Veterinary.builder().build());
		Mockito.when(veterinaryService.findAll()).thenReturn(veterinaries);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(veterinaryController).build();
		mockMvc.perform(
				       MockMvcRequestBuilders
						       .get("/veterinaries")
						       .contentType(MediaType.TEXT_HTML_VALUE)
		               )
		       .andExpect(status().isOk())
		       .andExpect(view().name("veterinary/index"))
		       .andExpect(model().attributeExists("veterinaries"))
		       .andExpect(model().attribute("veterinaries", veterinaries))
		       .andExpect(model().attribute("veterinaries", hasItem(
				       allOf(
						       hasProperty("id", is(43L)),
						       hasProperty("firstName", is("vet")),
						       hasProperty("lastName", is("rinart"))
				            )
		                                                           )));
	}
}
