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


import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.IEmployeRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	
	
	
private static final Logger L = LogManager.getLogger();
@Autowired
IEmployeService es;

@Autowired
IEmployeRepository erep;
	
	  @Test
		public void addEmployeTest()throws ParseException{
				
			
		  Employe e = new Employe("Driss","Ala eddine", "alaeddine.driss1@esprit.tn", true, "ala");
		  es.addEmploye(e);
		L.log(Level.INFO, () ->"ajouter Employe : " +e);
		

		}
	  @Test
		public void testRetrieveEmploye() {
			List<Employe> e = es.retrieveAllEmployes();
			
			L.log(Level.INFO, () ->"retrieve employe : " +e);
		}
	  @Test
		public void testdeleteEmploye(){
		  es.deleteEmployeById(1);	
		}
	  
			
		
	  @Test
	  public void testUpdateEmploye() {
		  Employe e=es.getEmployeById(1);
			e.setNomEmploye("Ala eddine "+" +");
			Employe ea= es.updateEmploye(e);
			Assert.assertEquals(e.getNomEmploye(), ea.getNomEmploye());
			}
	

}
