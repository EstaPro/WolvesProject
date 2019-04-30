package ma.rfidmaroc.patrolmanager.entities;

import java.util.Date;


public class Activite {

	private Long id_activite;
	private Date date_activite;

	public Activite(){

	}


	public void finalize() throws Throwable {

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

}