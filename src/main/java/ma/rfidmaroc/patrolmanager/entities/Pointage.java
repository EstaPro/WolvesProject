package ma.rfidmaroc.patrolmanager.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//@Entity
//@DiscriminatorValue(value="PT")
public abstract class Pointage extends Activite implements Serializable{
//	@Id
	private Long id_pointage;
	private Checkpoint m_Checkpoint;
//	@ManyToOne
//	@JoinColumn(name="ID_PAT")
	private Patrouilleur patrouilleur;
	

	public Pointage() {
		super();
	}

	public Pointage(Date date_activite, String geo_localisation, Checkpoint m_Checkpoint) {
		super(date_activite, geo_localisation);
		this.m_Checkpoint = m_Checkpoint;
	}

	public Checkpoint getM_Checkpoint() {
		return m_Checkpoint;
	}

	public void setM_Checkpoint(Checkpoint m_Checkpoint) {
		this.m_Checkpoint = m_Checkpoint;
	}
}