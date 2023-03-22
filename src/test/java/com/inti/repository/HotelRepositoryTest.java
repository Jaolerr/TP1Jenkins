package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Hotel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HotelRepositoryTest {

	private Hotel h1, savedHotel;
	
	@Autowired
	IHotelRepository ihr;
	
	@BeforeEach
	public void setUp() {
		h1=new Hotel ("nomTestHotel",3);
		savedHotel = ihr.save(h1);
	}
	// test createHotel
	@Test
	public void saveHotel() {
		assertThat(savedHotel).isNotNull();
		assertThat(savedHotel.getIdHotel()).isNotNull();
	}
//	//test getHotel(id)
//	@Test
//	public void getHotel() {
//		Hotel h2 = ihr.getReferenceById(savedHotel.getIdHotel());
//	}
	
}
