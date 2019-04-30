package ma.rfidmaroc.patrolmanager.entities;


public class Tag {

	private String contenu;
	private Long id_tag;

	public Tag(){

	}

	public void finalize() throws Throwable {

	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Long getId_tag() {
		return id_tag;
	}

	public void setId_tag(Long id_tag) {
		this.id_tag = id_tag;
	}

}