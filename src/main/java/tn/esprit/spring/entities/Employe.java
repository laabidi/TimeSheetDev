package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "T_EMPLOYE")
public class Employe implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long idEmploye;
	
	@Column(name="NOM")
	private String nomEmploye;
	
	@Column(name="PRENOM")
	private String prenomEmploye;
	
	@Column(name="EMAIL")
	private String emailEmploye;
	
	private boolean actif;
	
	@Column(name="PASSWORD")
	private String password;

	public long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getEmailEmploye() {
		return emailEmploye;
	}

	public void setEmailEmploye(String emailEmploye) {
		this.emailEmploye = emailEmploye;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Employe(String nomEmploye, String prenomEmploye, String emailEmploye, boolean actif, String password) {
		super();
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.emailEmploye = emailEmploye;
		this.actif = actif;
		this.password = password;
	}

	public Employe() {
	
	}
	
	
}