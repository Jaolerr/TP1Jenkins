package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Reservation {
	@Id
	private int idReserv;
	private LocalDate dateReservation;
	private int nbJours;
	//private Hotel hotel;
	//private Voyageur voyageur;
	

}
