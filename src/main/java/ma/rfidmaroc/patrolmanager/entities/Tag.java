package ma.rfidmaroc.patrolmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SuppressWarnings("serial")
public class Tag {

	@Id
	@GeneratedValue
	private Long id_tag;
	@Column(length=50)
	@NotEmpty
	private String contenu;

	public Tag(){

	}
	
	public Tag(String contenu){
		this.contenu=contenu;
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