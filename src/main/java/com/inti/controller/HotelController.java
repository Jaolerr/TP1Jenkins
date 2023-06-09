package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Hotel;
import com.inti.repository.IHotelRepository;


@Controller @RequestMapping("hotel")
public class HotelController {
	@Autowired
	IHotelRepository ihr;
	
	@GetMapping("createHotel")
	public String formHotel() {
		return "createHotelForm";
	}
	
	@PostMapping("saveHotel")
	public String saveHotel(@ModelAttribute("hotel") Hotel h) {
		ihr.save(h);
		return "redirect:/destination";
	}
	
	@GetMapping("top")
	public String topHotel(Model m) {
		m.addAttribute("Hotels",ihr.findTopHotel());
		System.out.println(ihr.findTopHotel());
		
		return "topHotels";
		
	}
	
	@GetMapping("reserver")
	public String reserver(@RequestParam("id") Long id, Model m) {
		m.addAttribute(ihr.findById(id));
		
	return "reserverHotel";
		
	}
	
	@PostMapping("reserver")
	public String saveResa() {
		
		return "redirect:top";
	}
	
//	@GetMapping("listeHotels")
//	public String listeHotels(Model m)
//	{
//		
//		m.addAttribute("listeH", ihr.findAll());
//		return "listeHotels";
//	}
//	
//	@GetMapping("deleteHotel/{nHotel}")
//	public String deleteHotel(@PathVariable("nHotel") long id) {
//	
//		ihr.deleteById(id);
//		
//		return "redirect:/listeHotels";
//	}
//	
//
//	@GetMapping("modifHotel/{nHotel}")
//	public String modifHotel(@PathVariable("nHotel") long id, Model m) 
//	{
//		m.addAttribute("Hotel", ihr.getReferenceById(id));
//		System.out.println(m);
//		return "modifHotel";
//	}
//	
//	@PostMapping("modifHotel")
//	public String updateHotel(@ModelAttribute("hotel") Hotel h) {
//		
//		ihr.save(h);
//		
//		return "redirect:/listeHotels";
//	}
}
