package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {

	public Employe addEmploye(Employe e);
	public List<Employe> retrieveAllEmployes();
	public void deleteEmployee(int id);
	public Employe updateEmploye(Employe e);
	public Optional<Employe> retrieveEmploye(String id);
	public Employe getEmployeById(int id);
	public void deleteEmployeById(int id);


}
