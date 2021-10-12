package tn.esprit.spring.services;



import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

	@Autowired
	EntrepriseRepository entR;
	
	
	private static final Logger l = LogManager.getLogger(IEntrepriseService.class);
	
	@Override
	public int addEntreprise(Entreprise e) {
		
		return Integer.valueOf(entR.save(e).getId());
	}


////test test///
	


	


	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		return entR.save(e);
	}



	@Override
	public Optional<Entreprise> retrieveEntreprise(int id) {

		
		
		return null;
	}









	@Override
	public void deleteEntreprise(long id) {
		// TODO Auto-generated method stub
		
	}









	@Override
	public Entreprise getEntrepriseById(int eId) {
		// TODO Auto-generated method stub
		return null;
	}






	

	
	
}
