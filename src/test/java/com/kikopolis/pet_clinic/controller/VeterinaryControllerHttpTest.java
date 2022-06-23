package com.kikopolis.pet_clinic.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VeterinaryControllerHttpTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void veterinaryListShouldReturnOk() {
		Assertions
				.assertThat(this.testRestTemplate.getForObject("http://localhost:" + this.port + "/veterinaries", String.class))
				.contains("Veterinaries");
	}
}
