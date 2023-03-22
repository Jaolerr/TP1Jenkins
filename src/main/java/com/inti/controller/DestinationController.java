package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Destination;
import com.inti.repository.IDestinationRepository;



@Controller @RequestMapping("destination")
public class DestinationController {

	@Autowired
	IDestinationRepository idr;
	
	@GetMapping("saveDestination")
	public String saveDestination() {
		return "saveDestination";
	}
	@PostMapping("saveDestination")
	public String saveDestination(@ModelAttribute("destination") Destination d)
	{
		idr.save(d);
		return "redirect:/destination/listeDestination";
	}
	
	
	@GetMapping("listeDestination")
	public String listeDestination(Model m) {
		m.addAttribute("listeD", idr.findAll());
		
		return "listeDestination";
	}
	
	@GetMapping("deleteDestination/{id}")
	public String deleteDestination(@PathVariable("id")long id) {
		idr.deleteById(id);
		return "redirect:/destination/listeDestination";
	}
	
	@GetMapping("updateDestination/{id}")
	public String updateDestination(@PathVariable("id") long id, Model m)
	{
		m.addAttribute("destination", idr.getReferenceById(id));
		return "updateDestination";
	}
	@PostMapping("updateDestination")
	public String updateDestination( @ModelAttribute("destination")Destination d)
	{
		
		idr.save(d);
		
		return "redirect:/destination/listeDestination";
	}
	
}
