package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Avis;
import com.inti.repository.IAvisRepository;

@Controller
public class AvisController {

	@Autowired
	IAvisRepository iar;
	
	@GetMapping("createAvis")
	public String createAvisForm() {
		return "createAvisForm";
	}
	
	@PostMapping("createAvis")
	public String createAvis(@ModelAttribute("avis") Avis a) {
		iar.save(a);
		return "redirect:/createAvis";
	}
	
}
