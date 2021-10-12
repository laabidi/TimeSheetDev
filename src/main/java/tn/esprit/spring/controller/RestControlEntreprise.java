package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RestController
public class RestControlEntreprise {

	
	
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	
	// Ajouter Entreprise : http://localhost:8081/SpringMVC/servlet/ajouterEntreprise
	//{"id":1,"name":"SSII Consulting","raisonSocial":"Cite El Ghazela"}

	@PostMapping("/ajouterEntreprise")
	@ResponseBody
	public int ajouterEntreprise(@RequestBody Entreprise ssiiConsulting) {
		ientrepriseservice.addEntreprise(ssiiConsulting);
		return ssiiConsulting.getId();
	}
	
    
    // http://localhost:8081/SpringMVC/servlet/deleteEntrepriseById/1
    @DeleteMapping("/deleteEntrepriseById/{identreprise}") 
	@ResponseBody 
	public void deleteEntrepriseById(@PathVariable("identreprise")int entrepriseId)
	{
		ientrepriseservice.deleteEntreprise(entrepriseId);
	}
    
    // http://localhost:8081/SpringMVC/servlet/getEntrepriseById/1
    @GetMapping(value = "getEntrepriseById/{identreprise}")
    @ResponseBody
	public Entreprise getEntrepriseById(@PathVariable("identreprise") int entrepriseId) {

		return ientrepriseservice.getEntrepriseById(entrepriseId);
	}
 	
	

    
}
