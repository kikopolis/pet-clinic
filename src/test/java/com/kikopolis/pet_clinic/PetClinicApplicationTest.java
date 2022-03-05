package com.kikopolis.pet_clinic;

import com.kikopolis.pet_clinic.controller.IndexController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PetClinicApplicationTest {
	@Autowired
	private IndexController controller;
	
	@Test
	public void contextLoads() {
		Assertions.assertThat(this.controller).isNotNull();
	}
}
