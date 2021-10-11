package tn.esprit.spring.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;

import java.util.List;

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
	public void addContratTest()throws ParseException, Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");	
		
	Contrat Contrat = new Contrat("2020-02-06","cdi",1500);
	
	contratServiceImpl.addContrat(Contrat);
assertThat(Contrat.getReference()).isGreaterThan(0);
L.info("le contrat est ajouté : "+ Contrat);

	}
	
	
	
	@Test
	public void testRetrieveContratByTypecontrat() {
		Contrat Contrat = new Contrat("2020-02-06","sivp",1500);
		
		//Ts.addContrat(Contrat);
		
		repo.findContractByTypecontrat("svip");

		
	L.info("retrieveContratByTypecontrat : "+ Contrat);
	}
	
	
	@Test
	public void testRetrieveContratt() {
		List<Contrat> cres = (List<Contrat>)contratServiceImpl.retrieveAllContrat();
		assertThat(cres).size().isGreaterThan(0);
		L.info("retrieveContratttttt : "+cres);
	}
	
	
	@Test
	public void testNumberOFContrat() {
		Long contrats =contratServiceImpl.numberOfContrat();
	
		L.info("le nombre d’éléments dans le table est : "+contrats);
	}	
	
	
	@Test
	public void TestdeleteContrat(){
		contratServiceImpl.deleteContrat(2);	
	}
	
	@Test
	public void testUpdateContrat () {
		Contrat p = repo.findContratByReference(2).get(0);
		p.setSalaire(29900);
		repo.save(p);
		
	}
	
}
