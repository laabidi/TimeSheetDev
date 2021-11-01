package tn.esprit.spring.repository;



import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Entreprise;

@Repository
public interface EntrepriseRepository extends CrudRepository<Entreprise, Long>  {

	List<Entreprise> findEntrepriseById(long l);

	
	
	
}
