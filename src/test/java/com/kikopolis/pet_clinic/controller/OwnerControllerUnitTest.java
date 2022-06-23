package com.kikopolis.pet_clinic.controller;

import com.kikopolis.pet_clinic.model.Owner;
import com.kikopolis.pet_clinic.service.OwnerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class OwnerControllerUnitTest {
	@Test
	public void ownerIndexShouldShowAllOwners() throws Exception {
		OwnerService    ownerService    = Mockito.mock(OwnerService.class);
		OwnerController ownerController = new OwnerController(ownerService);
		Set<Owner>      owners          = new HashSet<>();
		owners.add(Owner.builder().id(43L).firstName("sam").lastName("well").build());
		owners.add(Owner.builder().build());
		owners.add(Owner.builder().build());
		Mockito.when(ownerService.findAll()).thenReturn(owners);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
		mockMvc.perform(
				       MockMvcRequestBuilders
						       .get("/owners")
						       .contentType(MediaType.TEXT_HTML_VALUE)
		               )
		       .andExpect(status().isOk())
		       .andExpect(view().name("owner/index"))
		       .andExpect(model().attributeExists("owners"))
		       .andExpect(model().attribute("owners", owners))
		       .andExpect(model().attribute("owners", hasItem(
				       allOf(
						       hasProperty("id", is(43L)),
						       hasProperty("firstName", is("sam")),
						       hasProperty("lastName", is("well"))
				            )
		                                                     )));
	}
}
