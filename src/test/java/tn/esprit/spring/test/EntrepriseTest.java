package tn.esprit.spring.test;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	
	private static final Logger L = LogManager.getLogger();
	
	@Autowired
	EntrepriseServiceImpl entrepriseService;
	@Autowired
	EntrepriseRepository erep;

	  @Test
		public void addEntrepriseTest()throws ParseException{
				
			
		  Entreprise e = new Entreprise("Teslaaa","TES");
		  entrepriseService.addEntreprise(e);
		L.log(Level.INFO, () ->"ajouter Entreprise : " +e);
		

		}
	  @Test
		public void testRetrieveEntreprise() {
			List<Entreprise> e = entrepriseService.retrieveAllEntreprises();
			
			L.log(Level.INFO, () ->"retrieve entreprise : " +e);
		}
	  @Test
		public void testdeleteEntreprise(){
		  entrepriseService.deleteEntrepriseById(1);	
		}
	  
		
		
	  @Test
	  public void testUpdateEmploye() {
			Entreprise e=entrepriseService.getEntrepriseById(1);
			e.setName("Tesla"+" +");
			Entreprise es= entrepriseService.updateEntreprise(e);
			Assert.assertEquals(e.getName(), es.getName());
			}
	  }
	  
	  
	  
	  
	  
	  
	 
	
	  

