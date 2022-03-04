package com.kikopolis.petclinicweb.controller;

import com.kikopolis.petclinicweb.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {
	private final PetService petService;
	
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	@RequestMapping({"", "/"})
	public String index(Model model) {
		model.addAttribute("pets", this.petService.findAll());
		return "pet/index";
	}
}
