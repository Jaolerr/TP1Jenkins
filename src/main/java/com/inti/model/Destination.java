package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Destination {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long longitude;
	private long latitude;
	
	@Exclude
	@OneToMany @JoinColumn(name="idHotel")
	private List<Hotel> listeHotel;
	
	public Destination(long longitude, long latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
}
