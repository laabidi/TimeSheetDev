package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;



@RestController
public class RestControlContrat {
	@Autowired
	ContratServiceImpl contratServiceImpl;
	// http://localhost:8081/SpringMVC/servlet/Contract/add-contract
			@PostMapping("/add-contract")
			@ResponseBody
			public Contrat saveContract(@RequestBody Contrat cont) {
			Contrat contract =contratServiceImpl.save(cont);
			return contract;
			}
			
			
			// http://localhost:8081/SpringMVC/servlet/contrat/{typecontract}
			@GetMapping("/contrat/{typeContrat}")
			@ResponseBody
			public List<Contrat> findByType(@PathVariable("typeContrat") String typecontract) {
			return contratServiceImpl.findContractByTypecontract(typecontract);
			}
			
			
			
			// http://localhost:8081/SpringMVC/servlet/contrat-number
			@GetMapping("/contrat-number")
		    public  Long numberOfTransactions(){
		        
		        return contratServiceImpl.numberOfContrat();
		    }
}
