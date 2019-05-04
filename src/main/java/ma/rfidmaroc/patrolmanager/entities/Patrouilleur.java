package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("serial")
@DiscriminatorValue("PATR")
public class Patrouilleur extends Utilisateur implements Serializable {

//	@OneToMany(mappedBy="patrouilleur")
	private Pointage pointage;
//	@OneToMany(mappedBy="patrouilleur")
	private Reclamation reclamation;

	public Patrouilleur() {
		super();
	}

	public Patrouilleur(String nom,String prenom, Date date_naissance, String cin, String telephone, String login, String password,
			Boolean active) {
		super(nom, prenom, date_naissance, cin, telephone, login, password, active);
	}

	public Pointage getPointage() {
		return pointage;
	}

	public void setPointage(Pointage pointage) {
		this.pointage = pointage;
	}

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

}