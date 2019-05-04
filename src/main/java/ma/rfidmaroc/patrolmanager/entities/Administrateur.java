package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Administrateur extends Responsable implements Serializable{

	private String email;

	public Administrateur(){

	}

	public Administrateur(String nom, String prenom, Date date_naissance, String cin, String telephone, String email,
			String login, String password, String mat, Boolean active) {
		super(nom, prenom, date_naissance, cin, telephone, email, login, password, mat, active);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}