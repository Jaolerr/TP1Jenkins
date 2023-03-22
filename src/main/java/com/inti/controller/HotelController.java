package com.inti.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;


@Controller
public class HotelController {
	@Autowired
	IHotelRepository ihr;
	
	@GetMapping("formHotel")
	public String formHotel() {
		return "formHotel";
	}
	
	@PostMapping("saveHotel")
	public String saveHotel(@ModelAttribute("hotel") Hotel h) {
		ihr.save(h);
		return "redirect:/listeHotel";
	}
	
	@GetMapping("listeHotel")
	public String listeHotel(Model m)
	{
		
		m.addAttribute("listeH", ihr.findAll());
		return "listeHotel";
	}
	
	@GetMapping("deleteHotel/{nHotel}")
	public String deleteHotel(@PathVariable("nHotel") long id) {
	
		ihr.deleteById(id);
		
		return "redirect:/listeHotel";
	}
	

	@GetMapping("modifHotel/{nHotel}")
	public String modifHotel(@PathVariable("nHotel") long id, Model m) 
	{
		m.addAttribute("Hotel", ihr.getReferenceById(id));
		System.out.println(m);
		return "modifHotel";
	}
	
	@PostMapping("modifHotel")
	public String updateHotel(@ModelAttribute("Hotel") Hotel s) {
		
		ihr.save(s);
		
		return "redirect:/listeHotel";
	}
}
