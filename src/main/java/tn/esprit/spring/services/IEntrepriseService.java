package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public int addEntreprise(Entreprise e);
	public void deleteEntreprise(long id);
	public Entreprise getEntrepriseById(int eId);
	public List<Entreprise> retrieveAllEntreprises();
	public Entreprise updateEntreprise(Entreprise e);
	public Optional<Entreprise> retrieveEntreprise(int id);
}
