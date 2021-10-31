package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;
@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer>{
	

	

	

	List<Contrat> findContractByTypecontrat(String typecontract);



	List<Contrat> findContratByReference(int reference);



	Optional<Contrat> findByReference(int i);
} 
