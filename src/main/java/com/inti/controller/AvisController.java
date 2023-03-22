package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.inti.repository.IAvisRepository;

@Controller
public class AvisController {

	@Autowired
	IAvisRepository iaR;
	
	@GetMapping("createAvis")
	public String createAvisForm() {
		return "createAvisForm";
	}
}
