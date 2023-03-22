package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Voyageur;
import com.inti.repository.IVoyageurRepository;

@Controller
@RequestMapping("/voyageur")
public class VoyageurController {
	
	@Autowired
	IVoyageurRepository ivr;
	
	@GetMapping("inscription")
	public String inscription() {
		return "inscriptionVoyageur";
	}
	
	@PostMapping("createVoyageur")
	public String save(@ModelAttribute("voyageur") Voyageur v) {
		ivr.save(v);
		return "redirect:inscription";
		
	}
	
	@GetMapping("liste")
	public String liste(Model m) {
		m.addAttribute("listeVoyageur", ivr.findAll().toArray());
		
		return "afficherVoyageurs";
		
	}
	
	@GetMapping("supprimer")
	public String delete(@RequestParam(name = "id") Long id) {
		
		ivr.deleteById(id);
		return "redirect:liste";
	}

}
