package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Avis;
import com.inti.repository.IAvisRepository;

@Controller
public class AvisController {

	@Autowired
	IAvisRepository iar;
	
	@GetMapping("createAvis")
	public String createAvis() {
		return "createAvis";
	}
	
	@PostMapping("saveAvis")
	public String saveAvis(@ModelAttribute("avis") Avis a) {
		iar.save(a);
		return "redirect:/createAvis";
	}
	
	@GetMapping("ListeAvis")
	public String listeAvis(Model m) {
		List<Avis> listeA = iar.findAll();
		m.addAttribute("ListeA", listeA);
		System.out.println(listeA);
		return "ListeAvis";
	}
	
	@GetMapping("deleteAvis/{idAvis}")
	public String deleteAvis(@PathVariable int id) {
		iar.deleteById(id);
		return "redirect:/readAvis";
	}
	
	@GetMapping("updateAvis/{idAvis}")
	public String updateAvisForm(@PathVariable int id, Model m) {
		m.addAttribute("Avis", iar.getReferenceById(id));
		return "updateAvisForm";
	}

	@PostMapping("updateOeuvre")
	public String updateOeuvre(@ModelAttribute("av") Avis a) {
		iar.save(a);
		return "redirect:/listeAvis";
	}
}
