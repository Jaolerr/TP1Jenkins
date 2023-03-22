package com.inti.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Destination;
import com.inti.repository.IDestinationRepository;

@WebMvcTest(DestinationController.class)
public class DestinationControllerTest {

	

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private IDestinationRepository idr;
	
	@Test
	@DisplayName("Test d'enregistrement d'une destination")
	public void inscriptionDestination() throws Exception
	{
		mock.perform(get("/saveDestination"))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test d'enregistrement d'une destination")
	public void enregistrementDestination() throws Exception
	{
		mock.perform(post("/saveDestination").sessionAttr("Destination", new Destination(147,123)))
		.andExpect(status().is3xxRedirection())
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test d'affichage de toutes les destinations")
	public void getAllDestination() throws Exception
	{
		mock.perform(get("/listeDestination"))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Email")))
		.andDo(print());
	}
	
	@Test
	@DisplayName("Test de suppression d'une destination")
	public void deleteDestination() throws Exception
	{
		mock.perform(get("/deleteDestination/2"))
		.andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/listeDestination"))
		.andDo(print());
	}
}
