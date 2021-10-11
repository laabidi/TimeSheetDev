package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;



@Service
public class ContratServiceImpl implements IContratService {
	private static final Logger L =  LogManager.getLogger(ContratServiceImpl.class);

	@Autowired
	ContratRepository ContR;
	
	

	@Override
	public Contrat save(Contrat contract) {
		// TODO Auto-generated method stub
		return ContR.save(contract);
	}



	@Override
	public List<Contrat> findContractByTypecontract(String typecontract) {
		// TODO Auto-generated method stub
		return (List<Contrat>)ContR.findContractByTypecontrat(typecontract);
	}



	@Override
	public String addContrat(Contrat cont) {
		// TODO Auto-generated method stub
		ContR.save(cont);
		return"done";
	}



	@Override
	public List<Contrat> retrieveAllContrat() {
		// TODO Auto-generated method stub
		List<Contrat> contracts = (List<Contrat>) ContR.findAll();
		for (Contrat contract : contracts){
		L.info("contract +++: " + contract );}
		return contracts;
	}



	@Override
	public Long numberOfContrat() {
		// TODO Auto-generated method stub
		return ContR.count();
	}



	@Override
	public void deleteContrat(int reference) {
		// TODO Auto-generated method stub
		List<Contrat> subscription = ContR.findContratByReference(reference);
	    
	    
	        ContR.deleteById(reference);	
	}



	@Override
	public List<Contrat> findContratByReference(int reference) {
		// TODO Auto-generated method stub
		return (List<Contrat>)ContR.findContratByReference(reference);
	}
	}



	
	



	

	
	
	



	






	



	

	


	

