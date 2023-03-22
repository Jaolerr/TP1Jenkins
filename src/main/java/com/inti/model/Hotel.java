package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Entity @Data
@NoArgsConstructor @AllArgsConstructor
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idHotel;
	private String nom;
	private int nbEtoile;
	
	@Exclude
	@ManyToOne @JoinColumn(name="id")
	private Destination destination;

	@OneToMany(mappedBy = "hotel")
	@Exclude
	private List<Reservation> reservation;
	
	
	@Exclude
	@OneToMany (mappedBy = "hotel")
	private List<Avis> listeAvis;
	
	
	
	public Hotel(String nom, int nbEtoile) {
		super();
		this.nom = nom;
		this.nbEtoile = nbEtoile;
	}
	
}
