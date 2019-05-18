package ma.rfidmaroc.patrolmanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SuppressWarnings("serial")
public class Patrouille {

	@Id
	@GeneratedValue
	private Long id_patrouille;
	@NotEmpty
	private String nom_patr;
	@NotEmpty
	private String dureeMoyenne_min;
	@NotEmpty
	private String margeErr_min;

	public Patrouille(){

	}
	
	
	public Patrouille(String nom_patr, String dureeMoyenne_min, String margeErr_min){
		
		this.nom_patr = nom_patr;
		this.dureeMoyenne_min = dureeMoyenne_min;
		this.margeErr_min = margeErr_min;
	}

	public void finalize() throws Throwable {

	}
	
	public Long getId_patrouille() {
		return id_patrouille;
	}

	public void setId_patrouille(Long id_patrouille) {
		this.id_patrouille = id_patrouille;
	}
	
	public String getNom_patr() {
		return nom_patr;
	}

	public void setNom_patr(String nom_patr) {
		this.nom_patr = nom_patr;
	}

	public String getDureeMoyenne_min() {
		return dureeMoyenne_min;
	}

	public void setDureeMoyenne_min(String dureeMoyenne_min) {
		this.dureeMoyenne_min = dureeMoyenne_min;
	}

	public String getMargeErr_min() {
		return margeErr_min;
	}

	public void setMargeErr_min(String margeErr_min) {
		this.margeErr_min = margeErr_min;
	}

}