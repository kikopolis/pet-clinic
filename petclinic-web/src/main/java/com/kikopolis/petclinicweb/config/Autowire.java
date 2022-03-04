package com.kikopolis.petclinicweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class Autowire {
	@Bean
	public Random random() {
		return new Random();
	}
}
