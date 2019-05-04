package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
//@DiscriminatorValue("RC")
public class Reclamation extends Activite implements Serializable{

	private int id_rec;
	private String description;
	private String imgPath;
//	@ManyToOne
//	@JoinColumn(name="ID_PAT")
	private Patrouilleur patrouilleur;

	public Reclamation(){

	}

	public Reclamation(Date date_activite, String geo_localisation, String description, String imgPath, Patrouilleur patrouilleur) {
		super(date_activite, geo_localisation);
		this.description = description;
		this.imgPath = imgPath;
		this.patrouilleur = patrouilleur;
	}

	public int getId_rec() {
		return id_rec;
	}

	public void setId_rec(int id_rec) {
		this.id_rec = id_rec;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}