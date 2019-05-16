package ma.rfidmaroc.patrolmanager.models;


import org.hibernate.validator.constraints.NotEmpty;

public class TagForm {

	@NotEmpty
	private String contenu;
	

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
