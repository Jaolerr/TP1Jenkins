package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inti.model.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Long>{
	
	@Query(nativeQuery = true, value = "select * from hotel h order by h.nb_etoile desc")
	public List<Hotel> findTopHotel();

}
