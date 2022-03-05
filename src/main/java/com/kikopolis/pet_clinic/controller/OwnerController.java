package com.kikopolis.pet_clinic.controller;

import com.kikopolis.pet_clinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@RequestMapping({"", "/"})
	public String index(Model model) {
		model.addAttribute("owners", this.ownerService.findAll());
		return "owner/index";
	}
	
	@RequestMapping("/search")
	public String findOwners() {
		return "owner/search";
	}
}
