package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DepartementTest {
	
	
	  @Autowired
	  DepartementRepository drep;
	  
	  @Test
	  public void testAddDepartement() {

	 Departement d = new Departement("BLOC A");
	  
	 Departement savedDepartement = drep.save(d);
	  assertNotNull(savedDepartement);
	  }
	
	  
	  @Test
	  public void testUpdate () {
		  Departement d = drep.findById(1);
	  	d.setName("BLOC A");
	  	drep.save(d);
	  	
	  }
	  
	  @Test
	  public void testDelete () {
	  	drep.deleteById(1);
	  	assertThat(drep.existsById(1)).isFalse();
	  }
	 
	  
}