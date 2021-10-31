package tn.esprit.spring.contrattest;





import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.ParseException;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.ContratServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	@Autowired
	ContratServiceImpl contratServiceImpl;
	@Autowired
	ContratRepository repo;
	private static final Logger L =  LogManager.getLogger(ContratServiceImplTest.class);
	
	@Test
	public void addContratTest()throws ParseException{
			
		
	Contrat contrat = new Contrat("2020-02-06","cdi",1500);
	
	contratServiceImpl.addContrat(contrat);

L.log(Level.INFO, () ->"le contrat est ajouté : " +contrat);

	}
	
	
	
	@Test
	public void testRetrieveContratByTypecontrat() {
		Contrat contrat = new Contrat("2020-02-06","sivp",1500);
		
		
		
		repo.findContractByTypecontrat("svip");

		
	L.log(Level.INFO, () ->"retrieveContratByTypecontrat : " +contrat);
	}
	
	
	@Test
	public void testRetrieveContratt() {
		List<Contrat> cres = contratServiceImpl.retrieveAllContrat();
		
		L.log(Level.INFO, () ->"retrieveContratttttt : " +cres);
	}
	
	
	@Test
	public void testNumberOFContrat() {
		Long contrats =contratServiceImpl.numberOfContrat();
	
		L.log(Level.INFO, () ->"le nombre d’éléments dans le table est : "+contrats);
	}	
	
	
	@Test
	public void testdeleteContratt(){
		contratServiceImpl.deleteContrat(10);	
	}
	
	@Test
	public void testUpdateContrat () {
		Contrat p = repo.findContratByReference(11).get(0);
		p.setSalaire(298880);
		repo.save(p);
		
	}
	
}
