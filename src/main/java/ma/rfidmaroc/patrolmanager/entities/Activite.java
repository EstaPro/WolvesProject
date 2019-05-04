package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="TYPE_ACT", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class Activite implements Serializable {
	@Id @GeneratedValue
	private Long id_activite;
	private Date date_activite;
	private String geo_localisation;
//	@ManyToOne
//	@JoinColumn(name="ID_PAT")
	private Patrouilleur patrouilleur;

	public Activite(){

	}

	public Activite(Date date_activite, String geo_localisation) {
		super();
		this.date_activite = date_activite;
		this.geo_localisation = geo_localisation;
	}

	public Long getId_activite() {
		return id_activite;
	}

	public void setId_activite(Long id_activite) {
		this.id_activite = id_activite;
	}

	public Date getDate_activite() {
		return date_activite;
	}

	public void setDate_activite(Date date_activite) {
		this.date_activite = date_activite;
	}

	public String getGeo_localisation() {
		return geo_localisation;
	}

	public void setGeo_localisation(String geo_localisation) {
		this.geo_localisation = geo_localisation;
	}

	
}