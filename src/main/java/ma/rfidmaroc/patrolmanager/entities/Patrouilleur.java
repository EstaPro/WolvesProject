package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@SuppressWarnings("serial")
public class Patrouilleur implements Serializable{

	
	private Long id_patr;
	private String matricule_patr;

	public Patrouilleur(){
		super();
	}

//	public Patrouilleur(String nom, String prenom, Date date_naissance, String cin, String email, String telephone, String mat) {
//		super(nom, prenom, date_naissance, cin, email, telephone);
//		this.matricule_patr = mat;
//	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	
	public Long getId_patr() {
		return id_patr;
	}

	public void setId_patr(Long id_patr) {
		this.id_patr = id_patr;
	}

	public String getMatricule_patr() {
		return matricule_patr;
	}

	public void setMatricule_patr(String matricule_patr) {
		this.matricule_patr = matricule_patr;
	}
}