package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Avis;
import com.inti.model.Hotel;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AvisRepositoryTest {

	private Avis a1, savedAvis;
	
	@Autowired
	IAvisRepository iar;
	
	@BeforeEach
	public void setUp() {
		a1=new Avis ("commentaireTestAvis");
		savedAvis = iar.save(a1);
	}
	// test createAvis
	
	@Test
	public void saveHotel() {
		assertThat(savedAvis).isNotNull();
		assertThat(savedAvis.getIdAvis()).isNotNull();
	}

	
}