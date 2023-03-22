package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Voyageur {
	private Long id;
	private String nom;
	private String prenom;
	private int age;
	@OneToMany(mappedBy ="voyageur" )
	private List<Reservation> listReservation;

}
