package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;



@RestController
public class RestControlContrat {
	@Autowired
	ContratServiceImpl contratService;
	
			
			
			
			
			@GetMapping("/contrat/{typeContrat}")
			@ResponseBody
			public List<Contrat> findByType(@PathVariable("typeContrat") String typecontract) {
			return contratService.findContractByTypecontract(typecontract);
			}
			
			
			
			
			@GetMapping("/contrat-number")
		    public  Long numberOfTransactions(){
		        
		        return contratService.numberOfContrat();
		    }
}
