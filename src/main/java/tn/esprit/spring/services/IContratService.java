package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Contrat;



public interface IContratService {
	
	public Contrat save(Contrat contract);

	public List<Contrat> findContractByTypecontract(String typecontract);
	public String addContrat(Contrat cont);
	public List<Contrat> retrieveAllContrat() ;
	public Long numberOfContrat();
	void deleteContrat(int reference);
	List <Contrat> findContratByReference(int reference);
	
}
