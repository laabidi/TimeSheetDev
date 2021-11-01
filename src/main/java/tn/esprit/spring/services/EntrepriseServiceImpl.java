package tn.esprit.spring.services;



import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

	@PersistenceContext
	EntityManager em;
	@Autowired
	EntrepriseRepository erep;
	
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);


	@Override
	public Entreprise addEntreprise(Entreprise e) {
		return erep.save(e);
	}


	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises=(List<Entreprise>) erep.findAll();
			l.log(Level.INFO, () ->"entreprise : " +entreprises);
		return entreprises;
	}


	@Override
	public void deleteEntreprise(int id) {
	erep.deleteById(1L);
		
	}


	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		return erep.save(e);
	}


	@Override
	public Optional<Entreprise> retrieveEntreprise(String id) {
Optional<Entreprise> entreprise = erep.findById(Long.parseLong(id));
 l.log(Level.INFO, () ->"entreprise : " +entreprise);
	
return entreprise;
	}


	public Entreprise getEntrepriseById(int id) {
		Optional<Entreprise> e = erep.findById(1L);
		Entreprise en = new Entreprise();
		if (e.isPresent()) {
			  en= e.get();
			}
		return en;
	}
	
	


	@Override
	public void deleteEntrepriseById(int id) {
		{
			Optional<Entreprise> e = erep.findById(1L);

			Entreprise entreprise = new Entreprise();
			if (e.isPresent()) {
				entreprise= e.get();
				}
			
			erep.delete(entreprise);
		}
	
	}
	
}
	
	
	

