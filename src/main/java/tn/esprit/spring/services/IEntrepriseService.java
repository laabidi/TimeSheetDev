package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	
	public Entreprise addEntreprise(Entreprise e);
	public List<Entreprise> retrieveAllEntreprises();
	public void deleteEntreprise(int id);
	public Entreprise updateEntreprise(Entreprise e);
	public Optional<Entreprise> retrieveEntreprise(String id);
	public Entreprise getEntrepriseById(int id);
	public void deleteEntrepriseById(int id);
}
