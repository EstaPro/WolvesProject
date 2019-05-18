package ma.rfidmaroc.patrolmanager.models;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PatrouilleForm {

	@NotEmpty
	private String nom_patr;
	@NotEmpty
	private String dureeMoyenne_min;
	@NotEmpty
	private String margeErr_min;
	
	
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
