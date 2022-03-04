package com.kikopolis.petclinicweb.bootstrap;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OwnerLoader extends PersonLoader {
	public OwnerLoader(Random random) {
		super(random);
	}
}
