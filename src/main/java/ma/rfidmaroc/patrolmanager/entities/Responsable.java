package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("RESP")
public class Responsable extends Utilisateur implements Serializable{

	private String matricule_resp;
	@NotEmpty
	@Email
	private String email;

	public Responsable(){

	}


	public Responsable(String nom, String prenom, Date date_naissance, String cin, String telephone, String email, String login,
			String password, String mat, Boolean active) {
		super(nom, prenom, date_naissance, cin, telephone, login, password, active);


		this.matricule_resp = mat;
		this.email = email;
	}  


	public String getMatricule_resp() {
		return matricule_resp;
	}

	public void setMatricule_resp(String matricule_resp) {
		this.matricule_resp = matricule_resp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}