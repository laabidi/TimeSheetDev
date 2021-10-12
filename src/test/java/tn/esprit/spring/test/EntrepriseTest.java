package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EntrepriseTest {
	
	@Autowired
	  private TestEntityManager entityManager;

	  @Autowired
	  EntrepriseRepository erep;
	  
	  @Test
	  public void testAddEntreprise() throws ParseException {

	 Entreprise e = new Entreprise("Google","GG");
	  
	  Entreprise savedEntreprise = erep.save(e);
	  assertNotNull(savedEntreprise);
	  }
	  
	  @Test
	  public void testRead () {
		  Entreprise e = erep.findById(1);
	  	assertEquals("Delice", e.getName());
	  }
	  
	  
	  @Test
	  public void testFindEntrepriseByName() {
	      Entreprise e = erep.findByName("Google");    
	      assertThat(e.getName()).isEqualTo("Google");
	  }
	  @Test
	  public void testListEntreprises() {
	      List<Entreprise> entreprises = (List<Entreprise>) erep.findAll();
	      assertThat(entreprises).size().isGreaterThan(0);
	  }
	  @Test
	  public void testUpdate () {
	  	Entreprise e = erep.findById(3);
	  	e.setName("Coca");
	  	erep.save(e);
	  	
	  }
	  
	  @Test
	  @Rollback(false)
	  public void testUpdateEntreprise() {
		  Entreprise e = erep.findByName("Google");
	      e.setRaisonSocial("GG");
	       
	      erep.save(e);
	       
	      Entreprise updatedEntreprise = erep.findByName("Google");
	       
	      assertThat(updatedEntreprise.getRaisonSocial()).isEqualTo("GG");
	  }
	  @Test
	  @Rollback(false)
	  public void testDeleteEntreprise() {
	      Entreprise product = erep.findByName("Google");
	       
	      erep.deleteById(product.getId());
	       
	      Entreprise deletedEntreprise = erep.findByName("Google");
	       
	      assertThat(deletedEntreprise).isNull();       
	       
	  }
	  @Test
	  public void testDelete () {
	  	erep.deleteById(1);
	  	assertThat(erep.existsById(1)).isFalse();
	  }
	  
}
