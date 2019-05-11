package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("ADMIN")
public class Administrateur extends Utilisateur implements Serializable{
	
	private String matricule_admin;

	public Administrateur(){

	}

	public Administrateur(String nom, String prenom, Date date_naissance, String cin, String email, String telephone,
			String login, String password, String mat, Boolean active) {
		super(nom, prenom, date_naissance, cin, email, telephone, login, password, active);
		
		this.matricule_admin = mat;
	}


	
}