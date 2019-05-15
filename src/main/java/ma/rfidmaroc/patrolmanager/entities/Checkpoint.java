package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@SuppressWarnings("serial")
public class Checkpoint implements Serializable{

	@Id
	@GeneratedValue
	private Long id_checkpoint;
	@Column(length=50)
	@NotEmpty
	private String geo_location;
	//public Tag m_Tag;

	public Checkpoint(){

	}
	
	public Checkpoint(String geo_location){
			this.geo_location=geo_location;
	}


	public void finalize() throws Throwable {

	}

	public Long getId_checkpoint() {
		return id_checkpoint;
	}

	public void setId_checkpoint(Long id_checkpoint) {
		this.id_checkpoint = id_checkpoint;
	}

	public String getGeo_location() {
		return geo_location;
	}

	public void setGeo_location(String geo_location) {
		this.geo_location = geo_location;
	}

}