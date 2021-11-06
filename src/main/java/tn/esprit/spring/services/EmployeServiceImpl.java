package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.IEmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService{

	@Autowired
	IEmployeRepository erep;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);


	@Override
	public Employe addEmploye(Employe e) {
		return erep.save(e);
	}


	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes=(List<Employe>) erep.findAll();
			l.log(Level.INFO, () ->"employes : " +employes);
		return employes;
	}


	@Override
	public void deleteEmployee(int id) {
	erep.deleteById(1L);
		
	}


	@Override
	public Employe updateEmploye(Employe e) {
		return erep.save(e);
	}


	@Override
	public Optional<Employe> retrieveEmploye(String id) {
Optional<Employe> employe = erep.findById(Long.parseLong(id));
 l.log(Level.INFO, () ->"employe : " +employe);
	
return employe;
	}


	public Employe getEmployeById(int id) {
		Optional<Employe> e = erep.findById(1L);
		Employe en = new Employe();
		if (e.isPresent()) {
			  en= e.get();
			}
		return en;
	}
	
	


	@Override
	public void deleteEmployeById(int id) {
		
			Optional<Employe> e = erep.findById(1L);

			Employe employe = new Employe();
			if (e.isPresent()) {
				employe= e.get();
				}
			
			erep.delete(employe);
		}
	

	
}
