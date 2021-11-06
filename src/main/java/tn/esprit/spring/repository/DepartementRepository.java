package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Departement;
@Repository
public interface DepartementRepository extends CrudRepository<Departement, Long>{
	
	List<Departement> findDepartementById(long l);
}
