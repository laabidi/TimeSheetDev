package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;



@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger logger =  LogManager.getLogger(ContratServiceImpl.class);

	@Autowired
	ContratRepository contRepository;
	
	

	@Override
	public Contrat save(Contrat contract) {
		
		return contRepository.save(contract);
	}



	@Override
	public List<Contrat> findContractByTypecontract(String typecontract) {
		
		return contRepository.findContractByTypecontrat(typecontract);
	}



	@Override
	public String addContrat(Contrat cont) {
		
		contRepository.save(cont);
		return"done";
	}



	@Override
	public List<Contrat> retrieveAllContrat() {
		
		List<Contrat> contracts = (List<Contrat>) contRepository.findAll();
		for (Contrat contract : contracts){
		logger.log(Level.INFO, () ->"contracts:" +contract);}
		return contracts;
	}



	@Override
	public Long numberOfContrat() {
		
		return contRepository.count();
	}



	@Override
	public void deleteContrat(int reference) {
		
		
	    
	    
		contRepository.deleteById(reference);	
	}



	@Override
	public List<Contrat> findContratByReference(int reference) {
		
		return contRepository.findContratByReference(reference);
	}
	}



	
	



	

	
	
	



	






	



	

	


	

