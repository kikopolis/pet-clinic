package com.kikopolis.pet_clinic.controller;

import com.kikopolis.pet_clinic.service.VeterinaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/veterinaries")
public class VeterinaryController {
	private final VeterinaryService veterinaryService;
	
	public VeterinaryController(VeterinaryService veterinaryService) {
		this.veterinaryService = veterinaryService;
	}
	
	@RequestMapping({"", "/"})
	public String index(Model model) {
		model.addAttribute("veterinaries", this.veterinaryService.findAll());
		return "veterinary/index";
	}
}
