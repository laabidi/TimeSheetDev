package tn.esprit.spring.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contrat implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reference;
	
	
	private String dateDebut;
	
	private String typecontrat;
	
	private float salaire;
	

	
	
	


	
	




	










	public Contrat(String typecontrat, float salaire) {
		super();
		this.typecontrat = typecontrat;
		this.salaire = salaire;
	}










	public String getDateDebut() {
		return dateDebut;
	}










	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}










	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	
	

	public String getTypecontrat() {
		return typecontrat;
	}




	public void setTypecontrat(String typecontrat) {
		this.typecontrat = typecontrat;
	}




	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}










	public Contrat( String dateDebut, String typecontrat, float salaire) {
		super();
		
		this.dateDebut = dateDebut;
		this.typecontrat = typecontrat;
		this.salaire = salaire;
	}










	public Contrat() {
		
	}










	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}










	




	



	




	




	
	
	
}
